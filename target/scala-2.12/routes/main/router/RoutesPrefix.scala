// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/cwen/cwen/scala_projects/AmInChallenge/experiment/am-in-challenge/conf/routes
// @DATE:Fri Nov 30 12:20:17 EST 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}