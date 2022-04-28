package demo.processing

object NameMapping {
  def getNodeLabel(fileName: String): String = {
    fileName match {
      case "bioproject" => "bioproject"
      case "biosample" => "biosample"
      case "gene" => "gene"
      case "genome" => "genome"
      case "keywords" => "keywords"
      case "map_country" => "map_country"
      case "pubmed" => "pubmed"
      case "pubmed_pdf_png" => "pdf_png"
      case "taxonomy" => "taxonomy"
    }
  }

  def getRelationType(fileName: String): String = {
    fileName match {
      case "bioproject_country_rel" => "bioproject_country"
      case "pubmed_country_rel" => "pubmed_country"
      case "pubmed_keywords_rel" => "keyword"
      case "pubmed_pdf_png_rel" => "pubmed_png"
      case "taxonomy_bioproject_rel" => "taxonomy_bioproject"
      case "taxonomy_biosample_rel" => "taxonomy_biosample"
      case "taxonomy_gene_rel" => "taxonomy_gene"
      case "taxonomy_genome_rel" => "taxonomy_genome"
      case "taxonomy_pubmed_rel" => "produce"
      case "taxonomy_taxonomy_rel" => "parent"
    }
  }
}
