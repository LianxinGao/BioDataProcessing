package demo.processing

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-25 16:34
 */
object Script {
  def main(args: Array[String]): Unit = {
//    getScript("bioproject_country_rel.csv", "bioproject.csv_idMap", "map_country.csv_idMap")
//    getScript("pubmed_country_rel.csv", "pubmed.csv_idMap", "map_country.csv_idMap")
//    getScript("pubmed_keywords_rel.csv", "pubmed.csv_idMap", "keywords.csv_idMap")
//    getScript("pubmed_pdf_png_rel.csv", "pubmed.csv_idMap", "map_country.csv_idMap")
//    getScript("taxonomy_bioproject_rel.csv", "taxonomy.csv_idMap", "bioproject.csv_idMap")
//    getScript("taxonomy_biosample_rel.csv", "taxonomy.csv_idMap", "biosample.csv_idMap")
//    getScript("taxonomy_gene_rel.csv", "taxonomy.csv_idMap", "gene.csv_idMap")
//    getScript("taxonomy_genome_rel.csv", "taxonomy.csv_idMap", "genome.csv_idMap")
//    getScript("taxonomy_pubmed_rel.csv", "taxonomy.csv_idMap", "pubmed.csv_idMap")
    getScript("taxonomy_taxonmy_rel.csv", "taxonomy.csv_idMap", "taxonomy.csv_idMap")

  }

  def getScript(relFileName: String, nodeA: String, nodeB: String): Unit ={
    val pattern = s"./bin/spark-submit  --class ncbi.pandadb.pubmed_keywords_rel --master local  --driver-memory 8g  --executor-memory 40g --executor-cores 16  NCBI.jar /data/glx/ncbi/ncbi_import/$relFileName /data/glx/ncbi/ncbi_import/idMap/$nodeA /data/glx/ncbi/ncbi_import/idMap/$nodeB /data/glx/ncbi/ncbi_import/newRels"
    println(pattern)
  }
}
