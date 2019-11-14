package com.lolo.bigdata.scala.chapter10

/**
  * Scala WordCount
  *
  * 统计单词数，降序排列取前3
  */
object Scala10_WordCount extends App {

    // ("Hello Scala World", 4)
    // ("Hello World", 3)
    // ("Hello Hadoop", 2)
    // ("Hello HBase", 1)
    val linesList = List(("Hello Scala World", 4), ("Hello World", 3), ("Hello Hadoop", 2), ("Hello HBase", 1))
    /*
    ("Hello Scala World", 4)
    ("Hello", 4),("Scala", 4)..("Hello", 3),("World", 3)..
    ("Hello", 7),("Scala", 7)
     */
    //val strings: List[String] = linesList.flatMap(x => x._1.split(" "))
    //val wordAndCounts: List[(Array[String], Int)] = linesList.map(t => {(t._1.split(" "), t._2)})
    // 思路：不要想着一步实现，可以在flatMap内部使用map
    val wordAndCount: List[(String, Int)] = linesList.flatMap(t => {
        val words = t._1.split(" ")
        words.map(word => (word, t._2))
    })
    //println(wordAndCount)

    val groupWords: Map[String, List[(String, Int)]] = wordAndCount.groupBy(x => x._1)
    //Hello -> List((Hello,4), (Hello,3), (Hello,2), (Hello,1))
    //==> List((4), (3), (2), (1)) == t._2.map(x => x._2).sum
    //==> List.sum
    val wordToSumMap: Map[String, Int] = groupWords.map(t => {
        //(t._1, t._2.sum) // 不行，实现不了
        //t._2.map(x => (x._1, x._2.sum)) // 不行，实现不了
        val countList: List[Int] = t._2.map(x => x._2)
        (t._1, countList.sum)
    })

    //Hello -> List((Hello,4), (Hello,3), (Hello,2), (Hello,1))
    val wordToCount: Map[String, Int] = groupWords.mapValues(data => data.map(t => t._2).sum)

    println(wordToSumMap)
    println(wordToCount)

    println(wordToCount.toList.sortWith((left, right) => left._2 > right._2).take(3))

}
