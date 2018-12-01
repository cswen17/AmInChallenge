package controllers

import javax.inject._
import java.util.concurrent.atomic.AtomicInteger
import java.util.UUID
import java.util.UUID.randomUUID

import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.mvc._
import play.db.NamedDatabase

import play.api.data.Form
import play.api.data.Forms.mapping
import play.api.data.Forms.{number, text, optional}
import play.api.Logger

import scala.concurrent.duration._
import scala.concurrent.{Await, ExecutionContext, Future, Promise}
import slick.jdbc.H2Profile.api._
import slick.jdbc.JdbcProfile

import models.AmnestyReport
import models.Schemas.AmnestyReportTable

@Singleton
class AmnestyReportController @Inject()(
    @NamedDatabase("h2mem1") protected val dbConfigProvider: DatabaseConfigProvider,
    cc: ControllerComponents
  )(implicit exec: ExecutionContext) extends AbstractController(cc) with HasDatabaseConfigProvider[JdbcProfile]{
  var amnestyReportID : AtomicInteger = new AtomicInteger(1)

  def show(id: Int) = Action { 
    val amnestyReportSeq: Seq[AmnestyReport] = Await.result(runGetAmnestyReport(id), Duration.Inf)
    val amnestyReport = amnestyReportSeq(0)
    var reportId = amnestyReport.reportId
    var isPublic = amnestyReport.isPublic
    var text = amnestyReport.text
    Ok(views.html.amnestyreportshow(reportId, isPublic, text))
  }

  private def runGetAmnestyReport(id: Int) = {
    val amnestyReports = TableQuery[AmnestyReportTable]
    db.run(amnestyReports.filter(_.id===id).result)
  }

  private def incAmnestyReportID() : Int = amnestyReportID.getAndIncrement

  def form = Action { implicit request =>
    Ok(views.html.forms.amnestyReport())
  }

  var amnestyReportForm = Form(
    mapping(
      "reportId" -> number(),
      "isPublic" -> optional(text()),
      "text" -> text()
      )(amnestyReportFormApply)(amnestyReportFormUnapply)
    )

  def amnestyReportFormApply(_reportId: Int, _isPublic: Option[String], _text: String) : AmnestyReport = {
    _isPublic.getOrElse("") match {
      case "on" => AmnestyReport(incAmnestyReportID(), 1, _text)
      case _ => AmnestyReport(incAmnestyReportID(), 0, _text)
    }
  }

  def amnestyReportFormUnapply(amnestyReport : AmnestyReport) : Option[(Int, Option[String], String)] = {
    amnestyReport.isPublic match {
      case 1 => Some(amnestyReport.reportId, Some("on"), amnestyReport.text)
      case _ => Some(amnestyReport.reportId, None, amnestyReport.text)
    }
  }

  def create() = Action { implicit request =>
    Logger.debug("Request body is" + request.body + ".")
    val amnestyReports = TableQuery[AmnestyReportTable]
    var amnestyReport = amnestyReportForm.bindFromRequest
    if (amnestyReport.hasGlobalErrors) {
      Ok("Errors [" + amnestyReport.globalErrors + "]")
    } else {
      if (amnestyReport.hasErrors) {
        val reportIdErrorMessage = "reportId errors are: " + amnestyReport.errors("reportId") + "\n"
        val textErrorMessage = "text errors are: " + amnestyReport.errors("text") + "\n"
        val isPublicErrorMessage = "isPublic errors are: " + amnestyReport.errors("isPublic") + "\n"
        Logger.warn(reportIdErrorMessage + textErrorMessage + isPublicErrorMessage)
        Ok(reportIdErrorMessage + textErrorMessage + isPublicErrorMessage)
      } else {
        var toInsert: AmnestyReport = amnestyReport.get
        Logger.debug("toInsert is: " + toInsert)
        db.run(amnestyReports += toInsert).map {_ => ()}
        val insertedSeq : Seq[AmnestyReport] = Await.result(db.run(amnestyReports.filter(_.id===toInsert.reportId).result), Duration.Inf)
        val inserted = insertedSeq(0)
        Redirect("/amnesty-reports")
      }
    }
  }

  def list = Action {
    val amnestyReports = TableQuery[AmnestyReportTable]
    val amnestyReportSeq = Await.result(db.run(amnestyReports.filter(_.isPublic===1).result), Duration.Inf)
    Ok(views.html.amnestyreportlist(amnestyReportSeq))
  }
}
