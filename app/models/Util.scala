package models

import javax.inject._
import scala.concurrent.duration._
import scala.concurrent.{Await}

import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.H2Profile.api._
import slick.jdbc.JdbcProfile

import models.Schemas._

/*********************************
 * Queries to HTML Select options
 *********************************/

object Utils {
  class Util @Inject()(protected val dbConfigProvider: DatabaseConfigProvider) extends HasDatabaseConfigProvider[JdbcProfile]{

    def inputRulesToSelectOptions(): Seq[(String, String)] = { 
      val inputRules = TableQuery[InputRuleTable]
      val inputRulesSeq: Seq[InputRule] = Await.result(db.run(inputRules.result), Duration.Inf)
      val inputRuleOptions : Seq[(String, String)] = {
        inputRulesSeq.map { inputRule =>
          val inputRuleID : Int = inputRule.id
          val inputRuleName: String = inputRule.ruleName
          (inputRuleID.toString, inputRuleName)
        }
      }
      inputRuleOptions
    }

    def inputRuleRelationsToSelectOptions(): Seq[(String, String)] = {
      val inputRules = TableQuery[InputRuleTable]
      val inputRuleRelations = TableQuery[InputRuleRelationTable]
      val inputRuleRelationsSeq: Seq[InputRuleRelation] = Await.result(db.run(inputRuleRelations.result), Duration.Inf)
      val inputRuleRelationOptions : Seq[(String, String)] = {
        inputRuleRelationsSeq.map { inputRuleRelation =>
          val inputRuleRelationID: Int = inputRuleRelation.id
          // Get all the names associated with the left and right IRs
          val left: Int = inputRuleRelation.rightID
          val right: Int = inputRuleRelation.leftID
          val relatedInputRulesQuery = inputRules.filter { i =>
            List(
              i.id === left,
              i.id === right
            ).reduceLeftOption(_ || _).getOrElse(true: Rep[Boolean])
          }
          val relatedNamesQuery = relatedInputRulesQuery.map {_.ruleName}
          val namesFromRelation: Seq[String] = Await.result(db.run(relatedNamesQuery.result), Duration.Inf)
          (
            inputRuleRelationID.toString,
            Seq(namesFromRelation(0), namesFromRelation(1)).toString
          )
        }
      }
      inputRuleRelationOptions
    }

  }
}
