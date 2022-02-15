package demo.processing

import demo.DemoMethod
import demo.category.nodes.{KeywordsProcessing, NodeProcessing, PubmedProcessing}
import demo.category.relations.Pubmed2Keywords

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-15 09:44
 */
object DemoRunner {
  def main(args: Array[String]): Unit = {
//    val keyword = new KeywordsProcessing(1)
//    val nextId = keyword.run()
//    val pubmed = new PubmedProcessing(nextId)
//    pubmed.run()
//    val keywords = new NodeProcessing(1, "keywords", "¤",
//  "/data/glx/ncbi/keywords.csv",
//  "/data/glx/ncbi/keywords-panda.csv",
//  "/data/glx/ncbi/keywords-id2md5.csv")
//  keywords.run()

    val relation = new Pubmed2Keywords
    relation.run()
  }
}
