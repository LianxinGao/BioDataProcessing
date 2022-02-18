package demo.category.relations

import demo.RelationDemoMethod

import java.io.{BufferedWriter, File, FileWriter}
import scala.io.Source

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-15 14:02
 */
class Pubmed2Keywords extends RelationDemoMethod{
  override val typeName: String = "pub2key"
  override val delimiter: String = "¤"
  override var globalId: Long = 1
  override val srcFile: String = "/data/glx/ncbi/new_pubmed_keywords_rel.csv"
  override val targetFile: String = "/data/glx/ncbi/pubmed2keyword.csv"

  val src = Source.fromFile(new File(srcFile))
  val target = new BufferedWriter(new FileWriter(targetFile), 10 * 1024 * 1024)

  override def run(): Long = {
    val iter = src.getLines()
    target.write(s":REL_ID$delimiter:TYPE$delimiter:START_ID$delimiter:END_ID")
    target.newLine()
    iter.next()
    while (iter.hasNext){
      val data = iter.next()
      val lineData = s"$globalId$delimiter$typeName$delimiter$data"
      target.write(lineData)
      target.newLine()
      globalId += 1
    }
    target.flush()
    target.close()
    src.close()
    globalId
  }
}
