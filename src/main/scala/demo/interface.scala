package demo

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-15 09:39
 */
trait DemoMethod {
  def run()
}

trait NodeDemoMethod{
  val label: String
  val delimiter: String
  var globalId: Long
  val srcFile: String
  val targetFile: String
  def run(): Long
}

trait RelationDemoMethod{
  val typeName: String
  val delimiter: String
  var globalId: Long
  val srcFile: String
  val targetFile: String
  def run(): Long
}