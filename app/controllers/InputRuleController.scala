package controllers

import java.util.concurrent.atomic.AtomicInteger
import javax.inject._
import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future, Promise}

import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.data.Forms.{number, text, optional}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.mvc._
import play.db.NamedDatabase
import org.h2.jdbc.JdbcSQLException
import slick.jdbc.H2Profile.api._
import slick.jdbc.JdbcProfile

import models._
import models.Schemas.{InputRuleTable, InputRuleRelationTable}
import models.Utils._

class InputRuleController @Inject() (
  @NamedDatabase("h2mem1") protected val dbConfigProvider: DatabaseConfigProvider, messagesAction: MessagesActionBuilder, cc: ControllerComponents)(implicit exec: ExecutionContext) extends AbstractController(cc) with HasDatabaseConfigProvider[JdbcProfile]{
    var inputRuleID: AtomicInteger = new AtomicInteger(1)
    var inputRuleRelationID: AtomicInteger = new AtomicInteger(1)

    def show(id: Int) = Action {
      val inputRules = TableQuery[InputRuleTable]
      val inputRuleSeq: Seq[InputRule] = Await.result(db.run(inputRules.filter(_.id===id).result), Duration.Inf)
      val inputRule = inputRuleSeq(0)
      val inputRuleId = inputRule.id
      val inputRuleType = inputRule.inputRuleType
      val regex = inputRule.regex
      val wordDistance = inputRule.wordDistance
      val ruleName = inputRule.ruleName
      val irrID = inputRule.irrID
      Ok(views.html.inputruleshow(inputRuleId, inputRuleType, regex, wordDistance, ruleName, irrID))
    }

    def createTable(id: Int) = Action {
      // Check if there is an InputRules table first
      try {
        val inputRules = TableQuery[InputRuleTable]
        val inputRuleSeq: Seq[InputRule] = Await.result(db.run(inputRules.filter(_.id===id).result), Duration.Inf)
        Ok("InputRules Table is already created")
      } catch {
        case sqle: JdbcSQLException => {
          val inputRules = TableQuery[InputRuleTable]
          val setup = DBIO.seq(inputRules.schema.create)
          db.run(setup)
          Ok("Created")
        }
        case other: Exception => Ok("Caught Exception: " + other)
      }
    }

    var inputRuleForm = Form(
      mapping(
        "id" -> number(),
        "inputRuleType" -> text(),
        "regex" -> optional(text()),
        "wordDistance" -> optional(number()),
        "ruleName" -> text(),
        "irrID" -> optional(number()),
        )(inputRuleFormApply)(InputRule.unapply)
    )

    private def incInputRuleID() : Int = inputRuleID.getAndIncrement

    def inputRuleFormApply(_id: Int, _inputRuleType: String, _regex: Option[String], _wordDistance: Option[Int], _ruleName: String, _irrID: Option[Int]) : InputRule = {
      InputRule(incInputRuleID(), _inputRuleType, _regex, _wordDistance, _ruleName, _irrID)
    }


    def form = Action { implicit request =>
      Ok(views.html.forms.inputRule())
    }

    def create = Action { implicit request =>
      val inputRules = TableQuery[InputRuleTable]
      val inputRule = inputRuleForm.bindFromRequest
      var toInsert : InputRule = inputRule.get
      db.run(inputRules += toInsert).map {_ => ()}
      Redirect("/input-rules")
    }

    def list = Action {
      val inputRules = TableQuery[InputRuleTable]
      val inputRulesSeq = Await.result(db.run(inputRules.result), Duration.Inf)
      Ok(views.html.inputrulelist(inputRulesSeq))
    }


    // InputRuleRelation
    var inputRuleRelationForm = Form(
      mapping(
        "id" -> number(),
        "leftID" -> number(),
        "rightID" -> number(),
        "outputCorpusID" -> optional(number())
      )(inputRuleRelationFormApply)(InputRuleRelation.unapply)
    )

    private def incInputRuleRelationID(): Int = inputRuleRelationID.getAndIncrement

    def inputRuleRelationFormApply(_id: Int, _leftID: Int, _rightID: Int, _outputCorpusID: Option[Int]) : InputRuleRelation = {
      InputRuleRelation(incInputRuleRelationID(), _leftID, _rightID, _outputCorpusID)
    }

    def formInputRuleRelation = messagesAction { implicit messagesRequest : MessagesRequest[AnyContent] =>
      val util : Util = new Util(dbConfigProvider)
      Ok(views.html.forms.inputRuleRelation(inputRuleRelationForm, util.inputRulesToSelectOptions))
    }

    def createInputRuleRelation = Action { implicit request =>
      val inputRuleRelations = TableQuery[InputRuleRelationTable]
      // Fold this and account for errors
      inputRuleRelationForm.bindFromRequest.fold (
        formWithErrors => {
          BadRequest(formWithErrors.toString)
        },
        toInsert => {
          //var toInsert : InputRuleRelation = formData.get
          db.run(inputRuleRelations += toInsert).map {_ => ()}
          Redirect("/input-rules")
        }
      )
    }
}
