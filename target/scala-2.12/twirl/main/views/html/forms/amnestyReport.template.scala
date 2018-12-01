
package views.html.forms

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._
/*1.2*/import helper._

object amnestyReport extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[RequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/()(implicit request: RequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.37*/(""" 
"""),format.raw/*3.1*/("""<div class="base-frame">
    <h2 class="hero-heading">
        Upload a New Amnesty Report
    </h2>

    <!--    <form action="/amnesty-report/create" method="post" class="hero-form"> -->
    """),_display_(/*9.6*/form(CSRF(routes.AmnestyReportController.create()))/*9.57*/ {_display_(Seq[Any](format.raw/*9.59*/("""
        """),format.raw/*10.9*/("""<input type="hidden" name="reportId" value="0"/>
        <label>Text:</label>
        <textarea type="text" id="amnesty-report-text" name="text"></textarea>

        <input type="checkbox" id="amnesty-report-is-public" name="isPublic">
            Make this report publicly browsable
        </input>

        <button>Submit</button>
    """)))}),format.raw/*19.6*/("""
"""),format.raw/*20.1*/("""</div>
"""))
      }
    }
  }

  def render(request:RequestHeader): play.twirl.api.HtmlFormat.Appendable = apply()(request)

  def f:(() => (RequestHeader) => play.twirl.api.HtmlFormat.Appendable) = () => (request) => apply()(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Nov 30 11:45:09 EST 2018
                  SOURCE: /Users/cwen/cwen/scala_projects/AmInChallenge/experiment/am-in-challenge/app/views/forms/amnestyReport.scala.html
                  HASH: 14eb2660cc0fad4e79028aa108cf41107c7aa1ba
                  MATRIX: 438->1|773->18|903->53|931->55|1150->249|1209->300|1248->302|1284->311|1653->650|1681->651
                  LINES: 17->1|22->2|27->2|28->3|34->9|34->9|34->9|35->10|44->19|45->20
                  -- GENERATED --
              */
          