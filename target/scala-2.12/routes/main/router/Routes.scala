// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/cwen/employment/personalProjects/AmInChallenge/conf/routes
// @DATE:Tue Dec 18 10:12:39 EST 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  HomeController_1: controllers.HomeController,
  // @LINE:10
  InputRuleController_0: controllers.InputRuleController,
  // @LINE:16
  AmnestyReportController_3: controllers.AmnestyReportController,
  // @LINE:25
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    HomeController_1: controllers.HomeController,
    // @LINE:10
    InputRuleController_0: controllers.InputRuleController,
    // @LINE:16
    AmnestyReportController_3: controllers.AmnestyReportController,
    // @LINE:25
    Assets_2: controllers.Assets
  ) = this(errorHandler, HomeController_1, InputRuleController_0, AmnestyReportController_3, Assets_2, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, InputRuleController_0, AmnestyReportController_3, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """input-rule/""" + "$" + """id<[^/]+>""", """controllers.InputRuleController.show(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """input-rule/create""", """controllers.InputRuleController.create"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """input-rule""", """controllers.InputRuleController.form"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """input-rules""", """controllers.InputRuleController.list"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """input-rule/createTable/""" + "$" + """id<[^/]+>""", """controllers.InputRuleController.createTable(id:Int)"""),
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
    HomeController_1.index,
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

  // @LINE:10
  private[this] lazy val controllers_InputRuleController_show1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("input-rule/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_InputRuleController_show1_invoker = createInvoker(
    InputRuleController_0.show(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.InputRuleController",
      "show",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """input-rule/""" + "$" + """id<[^/]+>""",
      """ App Controllers""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_InputRuleController_create2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("input-rule/create")))
  )
  private[this] lazy val controllers_InputRuleController_create2_invoker = createInvoker(
    InputRuleController_0.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.InputRuleController",
      "create",
      Nil,
      "POST",
      this.prefix + """input-rule/create""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_InputRuleController_form3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("input-rule")))
  )
  private[this] lazy val controllers_InputRuleController_form3_invoker = createInvoker(
    InputRuleController_0.form,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.InputRuleController",
      "form",
      Nil,
      "GET",
      this.prefix + """input-rule""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_InputRuleController_list4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("input-rules")))
  )
  private[this] lazy val controllers_InputRuleController_list4_invoker = createInvoker(
    InputRuleController_0.list,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.InputRuleController",
      "list",
      Nil,
      "GET",
      this.prefix + """input-rules""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_InputRuleController_createTable5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("input-rule/createTable/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_InputRuleController_createTable5_invoker = createInvoker(
    InputRuleController_0.createTable(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.InputRuleController",
      "createTable",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """input-rule/createTable/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_AmnestyReportController_show6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("amnesty-report/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AmnestyReportController_show6_invoker = createInvoker(
    AmnestyReportController_3.show(fakeValue[Int]),
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

  // @LINE:17
  private[this] lazy val controllers_AmnestyReportController_create7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("amnesty-report/create")))
  )
  private[this] lazy val controllers_AmnestyReportController_create7_invoker = createInvoker(
    AmnestyReportController_3.create,
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

  // @LINE:18
  private[this] lazy val controllers_AmnestyReportController_form8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("amnesty-report")))
  )
  private[this] lazy val controllers_AmnestyReportController_form8_invoker = createInvoker(
    AmnestyReportController_3.form,
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

  // @LINE:19
  private[this] lazy val controllers_AmnestyReportController_list9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("amnesty-reports")))
  )
  private[this] lazy val controllers_AmnestyReportController_list9_invoker = createInvoker(
    AmnestyReportController_3.list,
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

  // @LINE:25
  private[this] lazy val controllers_Assets_versioned10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned10_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
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
        controllers_HomeController_index0_invoker.call(HomeController_1.index)
      }
  
    // @LINE:10
    case controllers_InputRuleController_show1_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_InputRuleController_show1_invoker.call(InputRuleController_0.show(id))
      }
  
    // @LINE:11
    case controllers_InputRuleController_create2_route(params@_) =>
      call { 
        controllers_InputRuleController_create2_invoker.call(InputRuleController_0.create)
      }
  
    // @LINE:12
    case controllers_InputRuleController_form3_route(params@_) =>
      call { 
        controllers_InputRuleController_form3_invoker.call(InputRuleController_0.form)
      }
  
    // @LINE:13
    case controllers_InputRuleController_list4_route(params@_) =>
      call { 
        controllers_InputRuleController_list4_invoker.call(InputRuleController_0.list)
      }
  
    // @LINE:14
    case controllers_InputRuleController_createTable5_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_InputRuleController_createTable5_invoker.call(InputRuleController_0.createTable(id))
      }
  
    // @LINE:16
    case controllers_AmnestyReportController_show6_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_AmnestyReportController_show6_invoker.call(AmnestyReportController_3.show(id))
      }
  
    // @LINE:17
    case controllers_AmnestyReportController_create7_route(params@_) =>
      call { 
        controllers_AmnestyReportController_create7_invoker.call(AmnestyReportController_3.create)
      }
  
    // @LINE:18
    case controllers_AmnestyReportController_form8_route(params@_) =>
      call { 
        controllers_AmnestyReportController_form8_invoker.call(AmnestyReportController_3.form)
      }
  
    // @LINE:19
    case controllers_AmnestyReportController_list9_route(params@_) =>
      call { 
        controllers_AmnestyReportController_list9_invoker.call(AmnestyReportController_3.list)
      }
  
    // @LINE:25
    case controllers_Assets_versioned10_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned10_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
