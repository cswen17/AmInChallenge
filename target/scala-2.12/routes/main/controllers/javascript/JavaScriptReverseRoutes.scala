// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/cwen/employment/personalProjects/AmInChallenge/conf/routes
// @DATE:Tue Dec 18 10:12:39 EST 2018

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

  // @LINE:25
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseInputRuleController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def show: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.InputRuleController.show",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "input-rule/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:14
    def createTable: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.InputRuleController.createTable",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "input-rule/createTable/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:11
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.InputRuleController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "input-rule/create"})
        }
      """
    )
  
    // @LINE:12
    def form: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.InputRuleController.form",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "input-rule"})
        }
      """
    )
  
    // @LINE:13
    def list: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.InputRuleController.list",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "input-rules"})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseAmnestyReportController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def show: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AmnestyReportController.show",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "amnesty-report/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Int]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:19
    def list: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AmnestyReportController.list",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "amnesty-reports"})
        }
      """
    )
  
    // @LINE:17
    def create: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AmnestyReportController.create",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "amnesty-report/create"})
        }
      """
    )
  
    // @LINE:18
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
