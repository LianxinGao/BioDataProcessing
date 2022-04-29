package cypher0429

import java.util.regex.Pattern

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-04-29 09:40
 */


object CypherTest {
  val unknown1 = Pattern.compile("""match\s*\(.*taxonomy\)\s*where .*tax_id\s*=\s*'.*'\s*return \S as \S*""")
  val unknown2 = Pattern.compile("""match\s*\(.*taxonomy.*\)\s*return \S* as scientific_name""")
  val unknown3 = Pattern.compile("""match\s*\(.*taxonomy.*\)\s*-\[.*produce\].*\(.*pubmed\)\swhere.*>.*publish_date.*return count\(.*\) as num""")
  val unknown4 = Pattern.compile("""match.*>=.*unwind.*;.*match.*>=.*return distinct.*year, k, count.*order by year asc;""")
  val basicInfoOfTaxonomy = Pattern.compile("""match\s*\(.*\)\s*where\s*\S*\s*=\s*'\S*' return\s*n""")
  val totalPubmedOfTaxonomy = Pattern.compile("""match\s*\(.*taxonomy.*\)\s*-\s*\[.*]\s*->\s*\(.*pubmed\s*\)\s* return count\S* as \S*""")
  val countCited = Pattern.compile("""match\s*\(.*\)\s*-\s*\[.*]\s*->\s*\(.*\)\s*return sum\s*\(\s*tointeger.*\) as \S*""")
  val count3YearCited = Pattern.compile("""match\s*\(.*\)\s*-\s*\[.*]\s*->\s*\(.*\)\s*where \S*\s*<\s*tointeger.*\) return count\S* as \S*""")
  val earliest = Pattern.compile("""match\s*\(.*\)\s*-\s*\[.*]\s*->\s*\(.*\)\s*return min.*\) as \S*""")
  val findTop3LevelParent = Pattern.compile("""match \S*=.*\[.*1..3\].* return \S*""")
  val projectInfo = Pattern.compile("""match\s*\(.*\)\s*-\s*\[.*]\s*->\s*\(.*\)\s*return \S*.title.*bioproject_id.*smdt.*limit \S*""")
  val geneOfTaxonomy = Pattern.compile("""match\s*\(.*\)\s*-\s*\[.*]\s*->\s*\(.*\)\s*return.*title.*gene_id limit \S*""")
  val genomeOfTaxonomy = Pattern.compile("""match\s*\(.*\)\s*-\s*\[.*]\s*->\s*\(.*\)\s*return.*genome_id.*aacc limit \S*""")
  val paperTendency = Pattern.compile("""match\s*\(.*\)\s*-\s*\[.*]\s*->\s*\(.*\)\s* where tointeger.*>=\s*\S* return .*publish_date.*count\S* as \S* order by \S* \S*""")
  val topKTendency = Pattern.compile("""match\s*\(.*\)\s*-\s*\[.*]\s*->\s*\(.*\)\s* where.*>= \S*.*<= \S* unwind.*>=.*<=.* return.*publish_date.*count\S* as \S* order by \S* \S*""")
  val keywordRelation = Pattern.compile("""match\s*\(.*\)\s*-\s*\[.*]\s*->\s*\(.*\)\s* where.*with \S* as \S*.*unwind.*<>.*limit \S*""")
  val countKey = Pattern.compile("""match\s*\(.*\)\s*-\s*\[.*]\s*->\s*\(.*\)\s* where.* with.*unwind \S* as \S* return .*count.*limit \S*""")
  val distributionOfCountryOfPaper = Pattern.compile("""match\s*\(.*taxonomy.*\)\s*-\s*\[.*]\s*->\s*\(.*pubmed.*\)\s*-\[.*\]\s*->\s*\(.*map_country.*\) return.*country.*count\(.* as \S*""")
  val distributionOfCountryOfProject = Pattern.compile("""match\s*\(.*taxonomy.*\)\s*-\s*\[.*]\s*->\s*\(.*bioproject.*\)\s*-\[.*\]\s*->\s*\(.*map_country.*\) return.*country.*count\(.* as \S*""")
  val relativePaper = Pattern.compile("""match\s*\(.*taxonomy.*\)\s*-\s*\[.*]\s*->\s*\(.*pubmed.*\)\s* return.*pubmed_id.*title.*authors.*skip \S* limit \S*""")
  val relativePNG = Pattern.compile("""match\s*\(.*taxonomy.*\)\s*-\s*\[.*]\s*->\s*\(.*pubmed.*\)\s* return.*doi.*png.*caption as \S*""")
  val countProject = Pattern.compile("""match\s*\(.*taxonomy.*\)\s*-\s*\[.*]\s*->\s*\(.*bioproject.*\)\s* return count\S* as \S*""")
  val relativeProject = Pattern.compile("""match\s*\(.*taxonomy.*\)\s*-\s*\[.*]\s*->\s*\(.*bioproject.*\)\s* return.*scientific_name.*cen skip \S* limit \S*""")

  def cyperPatternCheck(str: String): Unit ={
    val cypher = str.toLowerCase.replaceAll("\r", " ").replaceAll("\n", " ").trim
    if (unknown1.matcher(cypher).matches()){
      println("unknown1")
    }
    if (unknown2.matcher(cypher).matches()){
      println("unknown2")
    }
    if (unknown3.matcher(cypher).matches()){
      println("unknown3")
    }
    if (unknown4.matcher(cypher).matches()){
      println("unknown4")
    }
    if (basicInfoOfTaxonomy.matcher(cypher).matches()){
      println("basicInfoOfTaxonomy")
    }
    if (totalPubmedOfTaxonomy.matcher(cypher).matches()){
      println("totalPubmedOfTaxonomy")
    }
    if (countCited.matcher(cypher).matches()){
      println("countCited")
    }
    if (count3YearCited.matcher(cypher).matches()){
      println("count3YearCited")
    }
    if (earliest.matcher(cypher).matches()){
      println("earliest")
    }
    if (findTop3LevelParent.matcher(cypher).matches()){
      println("findTop3LevelParent")
    }
    if (projectInfo.matcher(cypher).matches()){
      println("projectInfo")
    }
    if (geneOfTaxonomy.matcher(cypher).matches()){
      println("geneOfTaxonomy")
    }
    if (genomeOfTaxonomy.matcher(cypher).matches()){
      println("genomeOfTaxonomy")
    }
    if (paperTendency.matcher(cypher).matches()){
      println("paperTendency")
    }
    if (topKTendency.matcher(cypher).matches()){
      println("topKTendency")
    }
    if (keywordRelation.matcher(cypher).matches()){
      println("keywordRelation")
    }
    if (countKey.matcher(cypher).matches()){
      println("countKey")
    }
    if (distributionOfCountryOfPaper.matcher(cypher).matches()){
      println("distributionOfCountryOfPaper")
    }
    if (distributionOfCountryOfProject.matcher(cypher).matches()){
      println("distributionOfCountryOfProject")
    }
    if (relativePaper.matcher(cypher).matches()){
      println("relativePaper")
    }
    if (relativePNG.matcher(cypher).matches()){
      println("relativePNG")
    }
    if (countProject.matcher(cypher).matches()){
      println("countProject")
    }
    if (relativeProject.matcher(cypher).matches()){
      println("relativeProject")
    }
  }

  def getCyphers(): List[(Int, String)] ={
    val cypher = List(
      (1, """MATCH (n:taxonomy) where n.tax_id ='9606' RETURN n as node"""),
      (2, """MATCH (n:taxonomy) where n.tax_id ='9606' RETURN n"""),
      (3, """MATCH (n:taxonomy {tax_id:'9605'}) RETURN n.scientific_name as scientific_name"""),
      (4, """MATCH (t:taxonomy{tax_id:'9606'})-[:produce]->(p:pubmed) RETURN count(p) as num"""),
      (5, """MATCH (t:taxonomy{tax_id:'9606'})-[:produce]->(p:pubmed) RETURN sum(toInteger(p.cited_num)) as num"""),
      (6, """MATCH (t:taxonomy{tax_id:'9606'})-[:produce]->(p:pubmed) where 2018 > toInteger(left(p.publish_date, 4)) RETURN count(p) as num"""),
      (7, """MATCH (t:taxonomy{tax_id:'9606'})-[:produce]->(p:pubmed) where 2018 > toInteger(left(p.publish_date, 4)) RETURN sum(toInteger(p.cited_num)) as num"""),
      (8, """MATCH (t:taxonomy{tax_id:'9606'})-[:produce]->(p:pubmed) RETURN min(left(p.publish_date, 4)) as year"""),
      (9, """match t=(t0:taxonomy{tax_id:'9606'})-[r:parent*1..3]->(t2:taxonomy) return t"""),
      // smdt
      (10, """MATCH (t:taxonomy {tax_id:'9606'})-[r:taxonomy_bioproject]->(b:bioproject) return b.title as title, b.bioproject_id as bioproject_id order by b.smdt desc limit 20"""),
      (11, """MATCH (t:taxonomy{tax_id:'9606'})-[r:taxonomy_gene]->(g:gene) RETURN g.title as title, g.gene_id as gene_id limit 20"""),
      (12, """MATCH (t:taxonomy{tax_id:'9606'})-[r:taxonomy_genome]->(g:genome) RETURN g.genome_id as genome_id, g.aacc as aacc limit 20"""),
      (13, """MATCH (t:taxonomy {tax_id:'9606'})-[r:produce]->(p:pubmed) where toInteger(left(p.publish_date, 4)) >= 1980 RETURN distinct left(p.publish_date, 4) as year , count(p) as num order by year asc"""),
      (14, """MATCH (t:taxonomy {tax_id:'9606'})-[r:produce]->(p:pubmed) where p.keywords is not null and toInteger(left(p.publish_date,4)) >= 2012 unwind(split(toLower(p.keywords),';')) as keyword with distinct keyword as k, count(keyword) as num order by num desc limit 20 match (t:taxonomy {tax_id:'9606'})-[:produce]->(p:pubmed)  where p.keywords is not null and toInteger(left(p.publish_date,4)) >= 2012 and k in split(toLower(p.keywords),';')  return distinct left(p.publish_date,4) as year, k, count(p) as num order by year asc;"""),
      (15, """MATCH (t:taxonomy {tax_id:'9606'})-[r:produce]->(p:pubmed) where p.keywords is not null  with (split(toLower(p.keywords),';')) as keywords with keywords as keywords1, keywords as keywords2 unwind keywords1 as keyword1 unwind keywords2 as keyword2 with (keyword1 + ';' + keyword2) as keyword where keyword1 <> keyword2 return distinct keyword as keyword, count(keyword) as num order by num desc limit 500"""),
      (16, """MATCH (t:taxonomy {tax_id:'9606'})-[r:produce]->(p:pubmed) where p.keywords is not null  with (split(toLower(p.keywords),';')) as keywords unwind keywords as keyword return distinct keyword, count(keyword) as num order by num desc limit 1000"""),
      (17, """MATCH (t:taxonomy {tax_id:'9606'})-[r:produce]->(p:pubmed)-[pubmed_country]->(c:map_country) RETURN c.country as country, count(c.country) as num"""),
      (18, """MATCH (t:taxonomy {tax_id:'9606'})-[r:produce]->(p:pubmed) return count(p) as total"""),
      (19, """MATCH (t:taxonomy {tax_id:'9606'})-[r:produce]->(p:pubmed) return p.pubmed_id as pubmed_id, p.title as title, p.authors as authors, p.publish_date as publish_date, p.keywords as keywords SKIP 0 LIMIT 5"""),
      (20, """MATCH (t:taxonomy {tax_id:'9606'})-[r:produce]->(p:pubmed)-[pr:pubmed_png]->(p1:pdf_png) return p1.doi as doi, p1.png_path as png_path, p1.caption as caption"""),
      (21, """MATCH (t:taxonomy {tax_id:'9606'})-[r:taxonomy_bioproject]->(b:bioproject) RETURN count(b) as total"""),
      (22, """MATCH (t:taxonomy {tax_id:'9606'})-[r:taxonomy_bioproject]->(b:bioproject) RETURN t.scientific_name as scientific_name, b.bioproject_id as bioproject_id, b.title as title, b.cen as cen SKIP 0 LIMIT 5"""),
    )
    cypher
  }

  def main(args: Array[String]): Unit = {
    getCyphers().foreach(f => {
      println("====================================================================")
      println(f._1)
      cyperPatternCheck(f._2)
      println("====================================================================")
    })
  }
}
