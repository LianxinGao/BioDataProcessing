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
class KeywordsProcessing(gId: Long) extends NodeDemoMethod{
  override val label = "keywords"
  override val delimiter = "¤"
  override var globalId = gId
  override val srcFile: String = "/data/glx/ncbi/keywords.csv"
  override val targetFile: String = "/data/glx/ncbi/keywords-panda.csv"

  val id2md5 = new BufferedWriter(new FileWriter("/data/glx/ncbi/keywords-id2md5.csv"), 1024 * 1024 * 10)
  val src = Source.fromFile(new File(srcFile))
  val target = new BufferedWriter(new FileWriter(targetFile), 1024 * 1024 * 10)
  override def run(): Long = {
    val iter = src.getLines()
    // header
    target.write(s":ID${delimiter}:LABEL${delimiter}id${delimiter}keyword")
    target.newLine()

    // id2md5
    id2md5.write(s":ID${delimiter}id")
    id2md5.newLine()

    // body
    iter.next() // remove header
    while (iter.hasNext){
      val data = iter.next()
      id2md5.write(s"$globalId$delimiter${data.split(delimiter)(0)}")
      id2md5.newLine()
      val lineData = s"$globalId$delimiter$label$delimiter$data"
      globalId += 1
      target.write(lineData)
      target.newLine()
    }

    target.flush()
    target.close()
    id2md5.flush()
    id2md5.close()
    src.close()
    globalId
  }

}
