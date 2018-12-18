// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/cwen/employment/personalProjects/AmInChallenge/conf/routes
// @DATE:Tue Dec 18 10:12:39 EST 2018


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
