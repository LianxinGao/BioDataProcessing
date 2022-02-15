package demo.category.nodes

import java.io.{BufferedWriter, File, FileWriter}
import scala.io.Source

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-15 15:20
 */
class NodeProcessing (gId: Long, label: String, delimiter: String, srcFile: String, targetFile: String, idMapFile: String) {
  val id2uid = new BufferedWriter(new FileWriter(idMapFile), 1024 * 1024 * 10)
  val src = Source.fromFile(new File(srcFile))
  val target = new BufferedWriter(new FileWriter(targetFile), 1024 * 1024 * 10)
  var globalId: Long = gId

  def run(): Long ={
    val iter = src.getLines()
    val oldHeader = iter.next()

    // header
    target.write(s":ID${delimiter}:LABEL${delimiter}$oldHeader")
    target.newLine()

    // id2uid
    id2uid.write(s":ID${delimiter}uid")
    id2uid.newLine()

    // body
    while (iter.hasNext){
      val data = iter.next()
      id2uid.write(s"$globalId$delimiter${data.split(delimiter)(0)}")
      id2uid.newLine()
      val lineData = s"$globalId$delimiter$label$delimiter$data"
      globalId += 1
      target.write(lineData)
      target.newLine()
    }

    target.flush()
    target.close()
    id2uid.flush()
    id2uid.close()
    src.close()
    globalId
  }
}
