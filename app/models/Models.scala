package models

case class AmnestyReport(var reportId: Int, var isPublic: Int, var text: String) {
  def withReportId(_reportId: Int) : AmnestyReport = {
    this.reportId = _reportId
    this
  }

  override def toString = "AmnestyReport[reportId: " + reportId + ",isPublic: " + isPublic + ",text: " + text + "]"
}
