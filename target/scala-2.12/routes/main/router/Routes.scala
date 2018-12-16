// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/cwen/employment/personalProjects/AmInChallenge/conf/routes
// @DATE:Sat Dec 01 17:32:33 EST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_0: controllers.HomeController,
  // @LINE:13
  AmnestyReportController_2: controllers.AmnestyReportController,
  // @LINE:22
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_0: controllers.HomeController,
    // @LINE:13
    AmnestyReportController_2: controllers.AmnestyReportController,
    // @LINE:22
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, AmnestyReportController_2, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, AmnestyReportController_2, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """amnesty-report/""" + "$" + """id<[^/]+>""", """controllers.AmnestyReportController.show(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """amnesty-report/create""", """controllers.AmnestyReportController.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """amnesty-report""", """controllers.AmnestyReportController.form"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """amnesty-reports""", """controllers.AmnestyReportController.list"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_AmnestyReportController_show1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("amnesty-report/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AmnestyReportController_show1_invoker = createInvoker(
    AmnestyReportController_2.show(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AmnestyReportController",
      "show",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """amnesty-report/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_AmnestyReportController_create2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("amnesty-report/create")))
  )
  private[this] lazy val controllers_AmnestyReportController_create2_invoker = createInvoker(
    AmnestyReportController_2.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AmnestyReportController",
      "create",
      Nil,
      "POST",
      this.prefix + """amnesty-report/create""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_AmnestyReportController_form3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("amnesty-report")))
  )
  private[this] lazy val controllers_AmnestyReportController_form3_invoker = createInvoker(
    AmnestyReportController_2.form,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AmnestyReportController",
      "form",
      Nil,
      "GET",
      this.prefix + """amnesty-report""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_AmnestyReportController_list4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("amnesty-reports")))
  )
  private[this] lazy val controllers_AmnestyReportController_list4_invoker = createInvoker(
    AmnestyReportController_2.list,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AmnestyReportController",
      "list",
      Nil,
      "GET",
      this.prefix + """amnesty-reports""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_Assets_versioned5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned5_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:13
    case controllers_AmnestyReportController_show1_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_AmnestyReportController_show1_invoker.call(AmnestyReportController_2.show(id))
      }
  
    // @LINE:14
    case controllers_AmnestyReportController_create2_route(params@_) =>
      call { 
        controllers_AmnestyReportController_create2_invoker.call(AmnestyReportController_2.create)
      }
  
    // @LINE:15
    case controllers_AmnestyReportController_form3_route(params@_) =>
      call { 
        controllers_AmnestyReportController_form3_invoker.call(AmnestyReportController_2.form)
      }
  
    // @LINE:16
    case controllers_AmnestyReportController_list4_route(params@_) =>
      call { 
        controllers_AmnestyReportController_list4_invoker.call(AmnestyReportController_2.list)
      }
  
    // @LINE:22
    case controllers_Assets_versioned5_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned5_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
