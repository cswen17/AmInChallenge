// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/cwen/employment/personalProjects/AmInChallenge/conf/routes
// @DATE:Sat Dec 01 17:32:33 EST 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAmnestyReportController AmnestyReportController = new controllers.ReverseAmnestyReportController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAmnestyReportController AmnestyReportController = new controllers.javascript.ReverseAmnestyReportController(RoutesPrefix.byNamePrefix());
  }

}
