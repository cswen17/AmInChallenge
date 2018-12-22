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
    //val dbConn = dbConfigProvider.db // Database.forConfig("h2mem1")

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

  }
}
