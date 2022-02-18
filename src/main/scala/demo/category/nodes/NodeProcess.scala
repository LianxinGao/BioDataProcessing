package demo.category.nodes

import java.io.{BufferedWriter, File, FileWriter}
import scala.io.Source

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-18 10:47
 */
class NodeProcess(gId: Long, label: String, delimiter: String, srcFile: String, targetFile: String, pid2uidFile: String) {
  var globalId: Long = gId
  val pid2uid = new BufferedWriter(new FileWriter(pid2uidFile), 1024 * 1024 * 10)
  val src = Source.fromFile(new File(srcFile))
  val target = new BufferedWriter(new FileWriter(targetFile), 1024 * 1024 * 10)

  def run(): Long = {
    val iter = src.getLines()
    val oldHeader = iter.next().split(delimiter)
    val headerLength = oldHeader.length
    val pHeader = oldHeader.slice(1, headerLength).mkString(delimiter)
    // header
    target.write(s":ID${delimiter}:LABEL${delimiter}$pHeader")
    target.newLine()

    // pid2uid
    pid2uid.write(s":ID${delimiter}id")
    pid2uid.newLine()

    while (iter.hasNext) {
      val data = iter.next()
      val index = data.indexOf(delimiter)
      val id = data.slice(0, index)
      val resData = data.slice(index + 1, data.length)

      pid2uid.write(s"$globalId$delimiter$id")
      pid2uid.newLine()
      val lineData = s"$globalId$delimiter$label$delimiter$resData"
      globalId += 1
      target.write(lineData)
      target.newLine()
    }

    target.flush()
    target.close()
    pid2uid.flush()
    pid2uid.close()
    src.close()
    globalId
  }
}
