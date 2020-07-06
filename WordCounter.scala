package start

object WordCounter {
  def main(args: Array[String]): Unit = {
    val str = "java scala pyton java scala javascript scala java java pyton"
    val number = 2

    println(s"${number} most popular words:")
    getPopular(str, number).foreach(tuple => println(s"Word: ${tuple._1}, friquency: ${tuple._2}"))
  }

  def getPopular(str: String, number: Int): List[(String, Int)] = {
    str.split(" ").
      groupBy(x => x).
      map((entry) => (entry._1, entry._2.length)).
      toList.
      sortWith((ent1, ent2) => ent1._2 > ent2._2).
      take(number)
  }
}