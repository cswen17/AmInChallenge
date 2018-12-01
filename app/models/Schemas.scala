package models

import scala.concurrent.{Future, Await}
import scala.concurrent.duration.Duration
import scala.reflect.ClassTag

import java.sql.Date
import java.util.UUID

import slick.jdbc.H2Profile.api._


object Schemas extends App {
  class InputRule(tag: Tag) extends Table[(Int, String, String, Int, String)](tag, "INPUT_RULE") {
    def id = column[Int]("IR_ID", O.PrimaryKey)
    def inputRuleType = column[String]("TYPE")
    def regex = column[String]("REGEX")
    def wordDistance = column[Int]("WORD_DISTANCE")
    def aggregationRule = column[String]("AGG_RULE")

    def irrID = column[Int]("IRR_FK_ID")

    def * = (id, inputRuleType, regex, wordDistance, aggregationRule)
  }
  val inputRules = TableQuery[InputRule]

  class OutputCorpus(tag: Tag) extends Table[(Int, Boolean)](tag, "OUTPUT_CORPUS") {
    def id = column[Int]("OC_ID", O.PrimaryKey)
    def isPublic = column[Boolean]("IS_PUBLIC")

    def * = (id, isPublic)
  }
  val outputCorpi = TableQuery[OutputCorpus]

  // ------------ Begin Complex Related Tables ---------------

  // The way this will work to approximate the self
  // many-to-many relation is we sort the left and
  // right IDs in ascending order so that we can always
  // guarantee that the lesser ID gets selected on
  // the left... we'll see how far that takes us.
  class InputRuleRelation(tag: Tag) extends Table[(Int, Int, Int, Int)](tag, "INPUT_RULE_RELATION") {
    def id = column[Int]("IRR_ID", O.PrimaryKey)

    // InputRules Relations
    def leftID = column[Int]("IR_FK_ID_LEFT")
    def left = foreignKey("IR_FK_LEFT", leftID, inputRules)(_.id) 
    def rightID = column[Int]("IR_FK_ID_RIGHT")
    def right = foreignKey("IR_FK_RIGHT", rightID, inputRules)(_.id)

    // OutputCorpus Relations
    def outputCorpusID = column[Int]("OC_FK_ID")
    def outputCorpus = foreignKey("OC_FK", outputCorpusID, outputCorpi)(_.id)

    def * = (id, leftID, rightID, outputCorpusID)
  }
  val inputRuleRelations = TableQuery[InputRuleRelation]

  class ClassifiedOutputSchemaRelation(tag: Tag) extends Table[(Int, String, String, Int)](tag, "CLASSIFIED_OUTPUT_SCHEMA_RELATION") {
    def id = column[Int]("COSR_ID", O.PrimaryKey)
    def details = column[String]("DETAILS")
    def text = column[String]("TEXT")
    def outputCorpusID = column[Int]("OC_ID")

    def ocID = foreignKey("OC_FK", outputCorpusID, outputCorpi)(_.id)
    
    def * = (id, details, text, outputCorpusID)
  }
  val classifiedOutputSchemaRelations = TableQuery[ClassifiedOutputSchemaRelation] 

  class AmnestyReportTable(tag: Tag) extends Table[AmnestyReport](tag, "AMNESTY_REPORT") {
    def id = column[Int]("AR_ID", O.PrimaryKey)
    def isPublic = column[Int]("IS_PUBLIC")
    def text = column[String]("TEXT")

    def * = (id, isPublic, text) <> (AmnestyReport.tupled, AmnestyReport.unapply)
  }
  val amnestyReports = TableQuery[AmnestyReportTable]

  class User(tag: Tag) extends Table[(Int, String, String)](tag, "USER") {
    def id = column[Int]("USER_ID", O.PrimaryKey)
    def username = column[String]("USERNAME")
    def password = column[String]("PASSWORD")

    def * = (id, username, password)
  }
  val users = TableQuery[User]
}
