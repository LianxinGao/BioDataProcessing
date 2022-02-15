package demo.processing

import demo.DemoMethod

import java.io.{BufferedWriter, File, FileWriter}
import java.util.regex.Pattern
import scala.io.Source

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-15 09:08
 */
class ProcessingRelationHeader extends DemoMethod {
  val delimiter = "¤"
  val cType = "children"
  val pType = "parent"
  var globalId = 1

  val digitPattern = Pattern.compile("""[0-9]*""")

  override def run(): Unit = {
    val fileWriter = new BufferedWriter(new FileWriter(new File("/data/glx/tax_rel_processed.csv")), 1024 * 1024 * 10)
    val sourceFile = Source.fromFile("/data/glx/tax2tax.csv")
    val iter = sourceFile.getLines()
    iter.next()
    changeHeader(fileWriter, delimiter)
    writeCsvData(fileWriter, iter)
    fileWriter.flush()
    sourceFile.close()
    fileWriter.close()
  }

  def changeHeader(writer: BufferedWriter, delimiter: String): Unit ={
    writer.write(s":REL_ID$delimiter:TYPE$delimiter:START_ID$delimiter:END_ID")
    writer.newLine()
  }
  def writeCsvData(writer: BufferedWriter, dataIterator: Iterator[String]): Unit ={
    while (dataIterator.hasNext){
      val data = dataIterator.next()
      val pData = data.split("\t").map(f => f.trim).filter(p => p.nonEmpty)
      if (pData.size == 2){
        val cData = s"${pData(1)}$delimiter${pData(0)}"
        writer.write(s"$globalId$delimiter$pType$delimiter${pData.mkString(delimiter)}")
        writer.newLine()
        globalId += 1
        writer.write(s"$globalId$delimiter$cType$delimiter$cData")
        writer.newLine()
        globalId += 1
      }
    }
  }
}
