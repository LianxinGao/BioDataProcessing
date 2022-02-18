package demo.category.nodes

import demo.NodeDemoMethod

import java.io.{BufferedWriter, File, FileWriter}
import scala.io.Source

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-15 14:01
 */
class PubmedProcessing(gId: Long) extends NodeDemoMethod{
  override val label: String = "pubmed"
  override val delimiter: String = "¤"
  override var globalId: Long = gId
  override val srcFile: String = "/opt/hadoop/work/pandadb/pubmed.csv"
  override val targetFile: String = "/opt/hadoop/work/pandadb/glx/pubmed-panda.csv"

  val id2uid = new BufferedWriter(new FileWriter("/opt/hadoop/work/pandadb/glx/pubmed-id2uid.csv"), 1024 * 1024 * 10)
  val src = Source.fromFile(new File(srcFile))
  val target = new BufferedWriter(new FileWriter(targetFile), 1024 * 1024 * 10)

  override def run(): Long = {
    val iter = src.getLines()
    // header
    target.write(s":ID${delimiter}:LABEL${delimiter}uid¤title¤doi¤publish_date¤country¤authors¤keywords")
    target.newLine()

    // id2md5
    id2uid.write(s":ID${delimiter}uid")
    id2uid.newLine()

    // body
    iter.next() // remove header
    while (iter.hasNext){
      val data = iter.next()
      val index = data.indexOf(delimiter)
      val id = data.slice(0, index)
      val resData = data.slice(index + 1, data.length)
      if (data.length > 1){
        id2uid.write(s"$globalId$delimiter$id")
        id2uid.newLine()
        val lineData = s"$globalId$delimiter$label$delimiter$resData"
        globalId += 1
        target.write(lineData)
        target.newLine()
      }
      else println(data.mkString(delimiter))
    }

    target.flush()
    target.close()
    id2uid.flush()
    id2uid.close()
    src.close()
    globalId
  }
}
