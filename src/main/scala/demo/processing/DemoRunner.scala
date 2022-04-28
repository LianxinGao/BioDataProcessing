package demo.processing

import demo.category.nodes.NodeProcessTemplate
import demo.category.relations.RelationProcessTemplate

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
//    val nodesFilePath = args(0)
//    val relationFilePath = args(1)
//
//    var nodeGlobalId: Long = 1
    var relationGlobalId: Long = 1

//    val nodeFileNames = new File(nodesFilePath).list().filter(p => p.endsWith(".csv"))
    val relationFileNames = new File("/data/glx/ncbi/ncbi_import/rels").list().filter(p => p.endsWith(".csv"))

//    nodeFileNames.filter(p => !p.toLowerCase().contains("rel")).foreach(fileName => {
//      val label = NameMapping.getNodeLabel(fileName.slice(0, fileName.length - 4))
//      val node = new NodeProcessTemplate(nodeGlobalId, label, "¤",
//        s"$nodesFilePath/$fileName", s"$nodesFilePath/processed/nodes/${fileName}_p", s"$nodesFilePath/idMap/${fileName}_idMap")
//      nodeGlobalId = node.run()
//    })

    relationFileNames.filter(p => p.toLowerCase().contains("rel")).foreach(fileName => {
      val label = NameMapping.getRelationType(fileName.slice(0, fileName.length - 4))
      val rel = new RelationProcessTemplate(relationGlobalId, label, "¤",
        s"/data/glx/ncbi/ncbi_import/rels/$fileName",
        s"/data/glx/ncbi/ncbi_import/processed/rels/${fileName}_p")
      relationGlobalId = rel.run()
    })
  }
}
