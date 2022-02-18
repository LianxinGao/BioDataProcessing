package demo.category.relations

import java.io.{BufferedWriter, File, FileWriter}
import scala.io.Source

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-16 16:54
 */
class CleanBlankLine {
  val path = "/data/glx/ncbi/pubmed2keyword.csv"
  val newFile = "/data/glx/ncbi/pubmed2keyword-new.csv"
  val target = new BufferedWriter(new FileWriter(newFile), 1024 * 1024 * 10)
  val file = Source.fromFile(new File(path))
  val iter = file.getLines()
  println("go!")
  def run(): Unit ={
    while (iter.hasNext){
      val data = iter.next().trim
      if (data.split("¤").length == 4) {
        target.write(data)
        target.newLine()
      }
    }
    target.flush()
    target.close()
    file.close()
  }
}
