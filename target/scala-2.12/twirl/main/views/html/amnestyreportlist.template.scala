
package views.html

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
/*1.2*/import slick.jdbc.H2Profile.api._
/*2.2*/import models.AmnestyReport

object amnestyreportlist extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Seq[AmnestyReport],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(amnestyReports : Seq[AmnestyReport]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.1*/("""<a href="/amnesty-report">Create a Report</a>
<table>
    <th>
         <tr>
             <td>Report ID</td>
             <td>Is Public</td>
             <td>Text</td>
         </tr>
    </th>
    <tbody>
        """),_display_(/*15.10*/amnestyReports/*15.24*/.map/*15.28*/{report=>_display_(Seq[Any](format.raw/*15.37*/("""
            """),format.raw/*16.13*/("""<tr>
                <td>
                    """),_display_(/*18.22*/report/*18.28*/.reportId),format.raw/*18.37*/("""
                """),format.raw/*19.17*/("""</td>
                <td>
                    """),_display_(/*21.22*/report/*21.28*/.isPublic),format.raw/*21.37*/("""
                """),format.raw/*22.17*/("""</td>
                <td>
                    """),_display_(/*24.22*/report/*24.28*/.text),format.raw/*24.33*/("""
                """),format.raw/*25.17*/("""</td>
            </tr>
        """)))}),format.raw/*27.10*/("""
    """),format.raw/*28.5*/("""</tbody>
</table>
"""))
      }
    }
  }

  def render(amnestyReports:Seq[AmnestyReport]): play.twirl.api.HtmlFormat.Appendable = apply(amnestyReports)

  def f:((Seq[AmnestyReport]) => play.twirl.api.HtmlFormat.Appendable) = (amnestyReports) => apply(amnestyReports)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Nov 30 13:12:45 EST 2018
                  SOURCE: /Users/cwen/cwen/scala_projects/AmInChallenge/experiment/am-in-challenge/app/views/amnestyreportlist.scala.html
                  HASH: a3367aa6f797ecfe4121a28fdde096d2b92c939d
                  MATRIX: 432->1|473->36|829->66|960->104|1201->318|1224->332|1237->336|1284->345|1325->358|1399->405|1414->411|1444->420|1489->437|1564->485|1579->491|1609->500|1654->517|1729->565|1744->571|1770->576|1815->593|1879->626|1911->631
                  LINES: 17->1|18->2|23->4|28->5|38->15|38->15|38->15|38->15|39->16|41->18|41->18|41->18|42->19|44->21|44->21|44->21|45->22|47->24|47->24|47->24|48->25|50->27|51->28
                  -- GENERATED --
              */
          