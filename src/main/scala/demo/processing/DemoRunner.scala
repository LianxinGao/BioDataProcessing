package demo.processing

import demo.category.relations.{RelationProcessTemplate}

import java.io.File

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-15 09:44
 */
object DemoRunner {
  def  fileName2LabelName(fileName: String): String = fileName.slice(0, fileName.length - 4)

  def main(args: Array[String]): Unit = {
    val dataPath = args(0)

    var globalId: Long = 1
    val fileNames = new File(dataPath).list().filter(p => p.endsWith(".csv"))

//    fileNames.foreach(fileName => {
//      val label = fileName.slice(0, fileName.length - 4)
//      val node = new NodeProcess(globalId, label, "¤",
//        s"$dataPath/$fileName", s"$dataPath/processed/${fileName}_p", s"$dataPath/idMap/${fileName}_idMap")
//      globalId = node.run()
//    })
    fileNames.foreach(fileName => {
      val label = fileName.slice(0, fileName.length - 4)
      val rel = new RelationProcessTemplate(globalId, label, "¤",
        s"$dataPath/$fileName", s"$dataPath/rels/${fileName}_p")
      globalId = rel.run()
    })
  }
}
