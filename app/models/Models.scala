package models

case class AmnestyReport(var reportId: Int, var isPublic: Int, var text: String) {
  def withReportId(_reportId: Int) : AmnestyReport = {
    this.reportId = _reportId
    this
  }

  override def toString = "AmnestyReport[reportId: " + reportId + ",isPublic: " + isPublic + ",text: " + text + "]"
}

case class InputRule(var id: Int, var inputRuleType: String, var regex: Option[String], var wordDistance: Option[Int], var ruleName: String, var irrID: Option[Int]) {

  def withInputRule(_inputRule: InputRule) : InputRule = {
    this.irrID = _inputRule.irrID
    this
  }

  override def toString = "InputRule[id: " + id + ",inputRuleType: " + inputRuleType + ",regex(optional): " + regex + ",wordDistance(optional): " + wordDistance + ",ruleName: " + ruleName + "]"
}

case class InputRuleRelation(var id: Int, var leftID: Int, var rightID: Int, var outputCorpusID: Option[Int]) 

case class OutputCorpus() {
}
