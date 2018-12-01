// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/cwen/cwen/scala_projects/AmInChallenge/experiment/am-in-challenge/conf/routes
// @DATE:Fri Nov 30 12:20:17 EST 2018

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

  // @LINE:22
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:13
  class ReverseAmnestyReportController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def show(id:Int): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "amnesty-report/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Int]].unbind("id", id)))
    }
  
    // @LINE:16
    def list(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "amnesty-reports")
    }
  
    // @LINE:14
    def create(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "amnesty-report/create")
    }
  
    // @LINE:15
    def form(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "amnesty-report")
    }
  
  }


}
