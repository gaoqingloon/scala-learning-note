package com.lolo.bigdata.scala.chapter10

import scala.collection.mutable

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
  * list.mapValues()
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

    var list: List[Int] = List(1, 3, 2, 4, 3, 2, 3)

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


    // 11. 数据减少，不是结果变少 reduce，2个变成1个
    // 将集合的数据经过逻辑处理后只保留一个结果，具体的结果需要参考逻辑实现
    // List(1, 3, 2, 4, 3, 2, 3)
    // op: (A1, A1) => A1
    //list.reduce((left, right) => {left + right})
    val resultSum: Int = list.reduce(_ + _)  //list.sum
    val resultDiff: Int = list.reduce(_ - _)
    println(resultSum)
    println(resultDiff)


    // 12. reduceLeft <==> reduce
    // reduceRight ==> reversed.reduceLeft[B]((x, y) => op(y, x))
    //1, 2, 3, 4
    //reversed: 4,3,2,1
    println(list.reduceLeft(_ - _))
    println(list.reduceRight(_ - _))


    // 13. fold 折叠 == foldLeft(z)(op)
    // 也可以的集合数据进行简化，获取最终的一条结果
    // fold方法可以传递2个部分的参数，
    // 第一个部分参数表示集合之外的数据，
    // 第二个部分参数表示数据进行的逻辑

    list = List(1, 2, 3, 4)
    val sum: Int = list.fold(100)(_ - _)
    println(sum)

    // foldLeft: (((100-1)-2)-3)-4
    //reverse.foldLeft(z)((right, left) => op(left, right))
    // reverse: 4,3,2,1
    // foldLeft: (((100-4)-3)-2)-1
    // foldRight: 1-(2-(3-(4-100)))
    val resLeftSum: Int = list.foldLeft(100)(_ - _)
    println(resLeftSum)

    val resRightSum: Int = list.foldRight(100)(_ - _)
    println(resRightSum)


    /** 将两个Map进行合并，相同的key做累加，不同的key直接增加 */
    // a -> 4, b -> 2, c -> 5, d -> 1
    var map1 = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    var map2 = mutable.Map("a" -> 3, "c" -> 2, "d" -> 1)

    // map.get(k) == null ; v
    // map.get(k); map.get(k) + v
    // 集合中的每一个和集合之外的数据做累加
    val stringToInt: mutable.Map[String, Int] = map1.foldLeft(map2)((map, t) => {
        // "a" -> 1
        // map集合设置的方式 map(key)=value
        map(t._1) = map.getOrElse(t._1, 0) + t._2
        map
    })
    println(stringToInt)//Map(b -> 2, d -> 1, a -> 4, c -> 5)

    // map1和map2互换结果一样
    map1 = mutable.Map("a" -> 1, "b" -> 2, "c" -> 3)
    map2 = mutable.Map("a" -> 3, "c" -> 2, "d" -> 1)
    val stringToInt1: mutable.Map[String, Int] = map2.foldLeft(map1)((map, t) => {
        // "a" -> 3
        // map集合设置的方式 map(key)=value
        map(t._1) = map.getOrElse(t._1, 0) + t._2
        map
    })
    println(stringToInt1)//Map(b -> 2, d -> 1, a -> 4, c -> 5)


    /** flatMap操作 */
    val list1 = List(1, List(2, 3), List(4, 5), 6, List(7, 8))
    // 函数的入参和【输出】
    /*val list2: List[Any] = list1.flatMap(any => {
        if (any.isInstanceOf[List[Int]]) {
            any.asInstanceOf[List[Int]]
        } else {
            List(any)
        }
    })*/
    // 类型匹配match case，不同的类型不同的处理
    val list2: List[Any] = list1.flatMap(any => {
        any match {
            case isList: List[Int] =>
                isList
            case _ =>
                List(any)
        }
    })
    println(list2) //List(1, 2, 3, 4, 5, 6, 7, 8)

}
