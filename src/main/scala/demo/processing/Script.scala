package demo.processing

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-25 16:34
 */
object Script {
  def main(args: Array[String]): Unit = {
//    getScript("pubmed_keywords_rel.csv", "pubmed.csv_idMap", "keywords.csv_idMap")


//    getScript("pubmed_country_rel.csv", "pubmed.csv_idMap", "map_country.csv_idMap")
//    getScript("pubmed_pdf_png_rel.csv", "pubmed.csv_idMap", "pubmed_pdf_png.csv_idMap")
//    getScript("taxonomy_bioproject_rel.csv", "taxonomy.csv_idMap", "bioproject.csv_idMap")
//    getScript("taxonomy_gene_rel.csv", "taxonomy.csv_idMap", "gene.csv_idMap")
//    getScript("taxonomy_nucleotide_rel.csv", "taxonomy.csv_idMap", "nucleotide.csv_idMap")
    getScript("taxonomy_taxonmy_rel.csv", "taxonomy.csv_idMap", "taxonomy.csv_idMap")
    getScript("taxonomy_biosample_rel.csv", "taxonomy.csv_idMap", "biosample.csv_idMap")
    getScript("taxonomy_genome_rel.csv", "taxonomy.csv_idMap", "genome.csv_idMap")
    getScript("taxonomy_pubmed_rel.csv", "taxonomy.csv_idMap", "pubmed.csv_idMap")
  }

  def getScript(relFileName: String, nodeA: String, nodeB: String): Unit ={
    val pattern = s"./bin/spark-submit  --class cn.ncbi.pandadb.pubmed_keywords_rel --master local  --driver-memory 8g  --executor-memory 40g --executor-cores 16  commonUtil.jar /opt/hadoop/work/pandadb/ncbi_import/rels/$relFileName /opt/hadoop/work/pandadb/ncbi_import/nodes/idMap/$nodeA /opt/hadoop/work/pandadb/ncbi_import/nodes/idMap/$nodeB /opt/hadoop/work/pandadb/glx/new_rels"
    println(pattern)
  }
}
