// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/cwen/cwen/scala_projects/AmInChallenge/experiment/am-in-challenge/conf/routes
// @DATE:Fri Nov 30 12:20:17 EST 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:22
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseAmnestyReportController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def show: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AmnestyReportController.show",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "amnesty-report/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:16
    def list: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AmnestyReportController.list",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "amnesty-reports"})
        }
      """
    )
  
    // @LINE:14
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AmnestyReportController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "amnesty-report/create"})
        }
      """
    )
  
    // @LINE:15
    def form: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AmnestyReportController.form",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "amnesty-report"})
        }
      """
    )
  
  }


}
