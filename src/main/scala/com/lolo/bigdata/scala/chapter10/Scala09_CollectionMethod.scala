package com.lolo.bigdata.scala.chapter10

/**
  * 集合中常用的方法
  *
  * list.sum
  * list.max
  * list.min
  * list.product
  * list.reverse
  *
  * list.iterator
  * list.groupBy()
  * list.sortBy()
  * list.sortWith()
  * list.map()
  * list.take()
  * list.flatMap()
  * list.filter()
  * list.zip()
  * list.union()
  * list.intersect()
  * list.diff()
  *
  * list.reduce()
  * list.fold()
  */
object Scala09_CollectionMethod extends App {

    val list: List[Int] = List(1, 3, 2, 4, 3, 2, 3)

    // 1. 基本操作
    println("sum: " + list.sum)
    println("max: " + list.max)
    println("min: " + list.min)
    println("product: " + list.product)
    println("reverse: " + list.reverse)

    // 2. 通过指定函数的【返回值】进行分组
    val intToInts: Map[Int, List[Int]] = list.groupBy(x => x)
    intToInts.foreach(t => {println(t._1 + ": " + t._2)})
    /*
    2: List(2, 2)
    4: List(4)
    1: List(1)
    3: List(3, 3, 3)
     */

    // 根据每个元素的首字符分组。指定函数的【返回值】
    val stringList: List[String] = List("11", "12", "24", "23")
    val stringToStrings: Map[String, List[String]] =
        stringList.groupBy(s => {s.substring(0, 1)})
    stringToStrings.foreach(t => println(t._1 + ": " + t._2))
    /*
    2: List(24, 23)
    1: List(11, 12)
     */

    // 根据奇偶数分组。指定函数的【返回值】
    val intToStrings: Map[Int, List[String]] = stringList.groupBy(s => { s.toInt % 2 })
    intToStrings.foreach(t => println(t._1 + ": " + t._2))
    /*
    1: List(11, 23)
    0: List(12, 24)
     */


    // 3. 排序sortBy。指定函数的【返回值】
    val sortList: List[Int] = list.sortBy(x => x)
    println(sortList.mkString(", "))

    // 排序sortBy，根据字符串第二个字符
    val strings: List[String] = stringList.sortBy(s => { s.substring(1, 2) })
    println(strings.mkString(", "))


    // 4. 排序sortWith lt: (Int, Int) => Boolean
    // 升序：从小到大
    //val ints: List[Int] = list.sortWith((x, y) => {x < y})
    // 降序：从大到小
    val ints: List[Int] = list.sortWith((x, y) => {x > y})
    println(ints.mkString(", "))

    // 排序sortWith，根据字符串第二个字符，降序排序
    val strings1: List[String] = stringList.sortWith((str1, str2) => {
        str1.substring(1, 2) > str2.substring(1, 2)
    })
    println(strings1.mkString(", "))


    // 5. 迭代
    for (elem <- list.iterator) {
        print(elem + " ")
    }
    println()


    // 6. 映射（转换）
    // f: Int => B
    val tuples: List[(Int, Int)] = list.map(x => {(x, 1)})
    println(tuples)
    //List((1,1), (3,1), (2,1), (4,1), (3,1), (2,1), (3,1))

    val intToTuples: Map[Int, List[(Int, Int)]] = tuples.groupBy(t => t._1)
    println(intToTuples)
    //Map(2 -> List((2,1), (2,1)), 4 -> List((4,1)), 1 -> List((1,1)), 3 -> List((3,1), (3,1), (3,1)))

    val intToInt: Map[Int, Int] = intToTuples.map(x => {(x._1, x._2.size)})
    println(intToInt)
    //Map(2 -> 2, 4 -> 1, 1 -> 1, 3 -> 3)

    
    // wordCount
    val wordList = List("Hello", "Scala", "Scala", "Hello", "World", "Hadoop", "Hello", "World")

    //1.(Hello, List("Hello", "Hello"))
    val wordToListMap: Map[String, List[String]] = wordList.groupBy(s => s)

    //2.(Hello,2)
    val wordToCountMap: Map[String, Int] = wordToListMap.map(t => {(t._1, t._2.size)})

    //3.排序输出前3条
    val wordToList: List[(String, Int)] = wordToCountMap.toList
    val sortedList: List[(String, Int)] = wordToList.sortWith((left, right) => {left._2 > right._2})
    println(sortedList.take(3).mkString(", "))


    // 7. 扁平化操作 flatMap
    // 将一个整体中的内容拆成一个一个的个体
    val lineList = List("Hello World", "Hello Scala", "Hello Hadoop")
    val flatMapList: List[String] = lineList.flatMap(x => x.split(" "))
    println(lineList)
    //List(Hello World, Hello Scala, Hello Hadoop)
    println(flatMapList)
    //List(Hello, World, Hello, Scala, Hello, Hadoop)

    val res: List[(String, Int)] = flatMapList
        .groupBy(word => word)
        .map(t => (t._1, t._2.size))
        .toList
        .sortWith((left, right) => {left._2 > right._2})
        .take(2)
    println(res.mkString(", "))


    // 8. 过滤 filter(f: Int => Boolean)
    // 对集合的数据进行筛选过滤，true保留，false不保留
    val filterList: List[Int] = list.filter(x => {x % 2 == 0})
    println(filterList.mkString(", "))//2, 4, 2


    // 9. 拉链 zip
    // 将两个集合数据进行关联，关联后的数据形成了元组
    val tuples1: List[(Int, String)] = list.zip(stringList)
    println(tuples1.mkString(", "))


    // 10. 集合 并集、交集、差集
    println(list.union(List(1, 2, 3)).mkString(", "))
    println(list.intersect(List(1, 2, 3)).mkString(", "))
    println(list.diff(List(1, 2, 3)).mkString(", "))

}
