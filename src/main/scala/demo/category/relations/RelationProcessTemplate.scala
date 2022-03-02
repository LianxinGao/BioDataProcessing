package demo.category.relations

import java.io.{BufferedWriter, File, FileWriter}
import scala.io.Source

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-18 18:10
 */
class RelationProcessTemplate(gId: Long, label: String, delimiter: String, srcFile: String, targetFile: String){
  var globalId: Long = gId
  val src = Source.fromFile(new File(srcFile))
  val target = new BufferedWriter(new FileWriter(targetFile), 10 * 1024 * 1024)

  def run(): Long ={
    val iter = src.getLines()
    target.write(s":REL_ID$delimiter:TYPE$delimiter:START_ID$delimiter:END_ID")
    target.newLine()
    iter.next()
    while (iter.hasNext){
      val data = iter.next()
      if (data.split(delimiter).count(p => p.nonEmpty) == 2){
        val lineData = s"$globalId$delimiter$label$delimiter$data"
        target.write(lineData)
        target.newLine()
        globalId += 1
      }
    }
    target.flush()
    target.close()
    src.close()
    globalId
  }


}
