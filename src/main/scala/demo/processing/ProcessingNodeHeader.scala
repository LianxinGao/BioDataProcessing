package demo.processing

import demo.DemoMethod

import java.io.{BufferedWriter, File, FileWriter}
import scala.io.Source

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-14 18:18
 */
class ProcessingNodeHeader extends DemoMethod {
  val delimiter = "¤"
  val label = "taxonomy"
  var globalId = 1
  override def run(): Unit = {
    val fileWriter = new BufferedWriter(new FileWriter(new File("/data/glx/taxonomy_processed.csv")), 1024 * 1024 * 10)
    val file = Source.fromFile("/data/glx/taxonomy.csv")
    val iter = file.getLines()
    val oldHeader = iter.next()
    changeHeader(fileWriter, oldHeader)
    writeCsvData(fileWriter, iter)
    file.close()
    fileWriter.flush()
    fileWriter.close()
  }

  def changeHeader(writer: BufferedWriter, oldHeader: String): Unit ={
    writer.write(s":ID$delimiter:LABEL$delimiter$oldHeader")
    writer.newLine()
  }
  def writeCsvData(writer: BufferedWriter, dataIterator: Iterator[String]): Unit ={
    while (dataIterator.hasNext){
      val data = dataIterator.next()
      writer.write(s"$globalId$delimiter$label$delimiter$data")
      writer.newLine()
      globalId += 1
    }
  }
}
