package demo.processing

import demo.DemoMethod
import demo.category.nodes.{KeywordsProcessing, NodeProcess, PubmedProcessing}
import demo.category.relations.{CleanBlankLine, Pubmed2Keywords}

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-15 09:44
 */
object DemoRunner {
  def main(args: Array[String]): Unit = {
    val bioproject = new NodeProcess(1, "bioproject", "¤",
    "/opt/hadoop/work/pandadb/neo4j/nodes/bioproject.csv",
    "/opt/hadoop/work/pandadb/neo4j/nodes/processedNodes/panda-bioproject.csv",
    "/opt/hadoop/work/pandadb/neo4j/nodes/processedIds/panda-bioproject-IdMap.csv")

    val bid = bioproject.run()

    val gene = new NodeProcess(bid, "gene", "¤",
      "/opt/hadoop/work/pandadb/neo4j/nodes/gene.csv",
      "/opt/hadoop/work/pandadb/neo4j/nodes/processedNodes/panda-gene.csv",
      "/opt/hadoop/work/pandadb/neo4j/nodes/processedIds/panda-gene-IdMap.csv")

    val genid = gene.run()

    val genome = new NodeProcess(genid, "genome", "¤",
      "/opt/hadoop/work/pandadb/neo4j/nodes/genome.csv",
      "/opt/hadoop/work/pandadb/neo4j/nodes/processedNodes/panda-genome.csv",
      "/opt/hadoop/work/pandadb/neo4j/nodes/processedIds/panda-genome-IdMap.csv")

    val genomeId = genome.run()

    val keywords = new NodeProcess(genomeId, "keywords", "¤",
      "/opt/hadoop/work/pandadb/neo4j/nodes/keywords.csv",
      "/opt/hadoop/work/pandadb/neo4j/nodes/processedNodes/panda-keywords.csv",
      "/opt/hadoop/work/pandadb/neo4j/nodes/processedIds/panda-keywords-IdMap.csv")

    val keywordsId = keywords.run()

    val nucleotide = new NodeProcess(keywordsId, "nucleotide", "¤",
      "/opt/hadoop/work/pandadb/neo4j/nodes/nucleotide.csv",
      "/opt/hadoop/work/pandadb/neo4j/nodes/processedNodes/panda-nucleotide.csv",
      "/opt/hadoop/work/pandadb/neo4j/nodes/processedIds/panda-nucleotide-IdMap.csv")

    val nucleotideId = nucleotide.run()

    val pubmed = new NodeProcess(nucleotideId, "pubmed", "¤",
      "/opt/hadoop/work/pandadb/neo4j/nodes/pubmed.csv",
      "/opt/hadoop/work/pandadb/neo4j/nodes/processedNodes/panda-pubmed.csv",
      "/opt/hadoop/work/pandadb/neo4j/nodes/processedIds/panda-pubmed-IdMap.csv")

    val pubmedId = pubmed.run()

    val taxonomy = new NodeProcess(pubmedId, "taxonomy", "¤",
      "/opt/hadoop/work/pandadb/neo4j/nodes/taxonomy.csv",
      "/opt/hadoop/work/pandadb/neo4j/nodes/processedNodes/panda-taxonomy.csv",
      "/opt/hadoop/work/pandadb/neo4j/nodes/processedIds/panda-taxonomy-IdMap.csv")

    val taxonomyId = taxonomy.run()

    println(taxonomyId)
  }
}
