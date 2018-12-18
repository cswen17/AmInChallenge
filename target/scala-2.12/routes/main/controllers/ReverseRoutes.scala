// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/cwen/employment/personalProjects/AmInChallenge/conf/routes
// @DATE:Tue Dec 18 10:12:39 EST 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:7
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:25
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:10
  class ReverseInputRuleController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def show(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "input-rule/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:14
    def createTable(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "input-rule/createTable/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:11
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "input-rule/create")
    }
  
    // @LINE:12
    def form(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "input-rule")
    }
  
    // @LINE:13
    def list(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "input-rules")
    }
  
  }

  // @LINE:16
  class ReverseAmnestyReportController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def show(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "amnesty-report/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:19
    def list(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "amnesty-reports")
    }
  
    // @LINE:17
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "amnesty-report/create")
    }
  
    // @LINE:18
    def form(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "amnesty-report")
    }
  
  }


}
