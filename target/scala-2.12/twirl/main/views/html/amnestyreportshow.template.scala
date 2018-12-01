
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

object amnestyreportshow extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Int,Int,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: Int, isPublic: Int, text: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<h3>Is Public? """),_display_(/*2.17*/isPublic),format.raw/*2.25*/("""</h3>
<h5>Id: """),_display_(/*3.10*/id),format.raw/*3.12*/("""</h5>
<p>"""),_display_(/*4.5*/text),format.raw/*4.9*/("""</p>
"""))
      }
    }
  }

  def render(id:Int,isPublic:Int,text:String): play.twirl.api.HtmlFormat.Appendable = apply(id,isPublic,text)

  def f:((Int,Int,String) => play.twirl.api.HtmlFormat.Appendable) = (id,isPublic,text) => apply(id,isPublic,text)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Nov 29 22:20:11 EST 2018
                  SOURCE: /Users/cwen/cwen/scala_projects/AmInChallenge/experiment/am-in-challenge/app/views/amnestyreportshow.scala.html
                  HASH: 297627d74f774ed92ff4a12406bc35daa484be34
                  MATRIX: 749->1|881->40|923->56|951->64|992->79|1014->81|1049->91|1072->95
                  LINES: 21->1|26->2|26->2|26->2|27->3|27->3|28->4|28->4
                  -- GENERATED --
              */
          