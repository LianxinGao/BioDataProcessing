package demo.category.nodes

import demo.{DemoMethod, NodeDemoMethod}

import java.io.{BufferedWriter, File, FileWriter}
import scala.io.Source

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-15 13:59
 */
class KeywordsProcessing(gId: Long){
  val label = "keywords"
  val delimiter = "¤"
  var globalId = gId
  val srcFile: String = "/opt/hadoop/work/pandadb/neo4j/nodes/keywords.csv"
  val targetFile: String = "/opt/hadoop/work/pandadb/neo4j/nodes/processedNodes/keywords-panda.csv"
  val pid2uid: String = "/opt/hadoop/work/pandadb/neo4j/nodes/processedIds/keywords-pid2uid.csv"

  val id2md5 = new BufferedWriter(new FileWriter(pid2uid), 1024 * 1024 * 10)
  val src = Source.fromFile(new File(srcFile))
  val target = new BufferedWriter(new FileWriter(targetFile), 1024 * 1024 * 10)

  def run(): Long = {
    val iter = src.getLines()
    val oldHeader = iter.next().split(delimiter)
    val pHeader = oldHeader.slice(1, oldHeader.length).mkString(delimiter)
    // header
    target.write(s":ID${delimiter}:LABEL${delimiter}$pHeader")
    target.newLine()

    // id2md5
    id2md5.write(s":ID${delimiter}id")
    id2md5.newLine()

    while (iter.hasNext){
      val data = iter.next()
      val index = data.indexOf(delimiter)
      val id = data.slice(0, index)
      val resData = data.slice(index + 1, data.length)

      if  (data.length == 3){
        id2md5.write(s"$globalId$delimiter$id")
        id2md5.newLine()
        val lineData = s"$globalId$delimiter$label$delimiter$resData"
        globalId += 1
        target.write(lineData)
        target.newLine()
      }
      else println(data.mkString(delimiter))
    }

    target.flush()
    target.close()
    id2md5.flush()
    id2md5.close()
    src.close()
    globalId
  }

}
