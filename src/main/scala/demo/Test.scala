package demo

/**
 * @program: BioDataProcessing
 * @description:
 * @author: LiamGao
 * @create: 2022-02-15 18:35
 */
object Test {
  def main(args: Array[String]): Unit = {
    val a  = "AAAA¤BBB¤CC¤DDD"
    println(a.indexOf("¤"))
    println(a.slice(4, a.length))
    println(a.slice(0, 4))
  }
}
