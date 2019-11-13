package com.lolo.bigdata.scala.chapter10

/**
  * Tuple 元组
  *
  * 将无关的数据当成一个整体来使用 empId, email, orderNum
  * 使用()将数据关联在一起，形成一个整体，元组中数据最多为22个
  */
object Scala08_Tuple extends App {

    val tuple: (String, Int, String) = ("gql", 102, "lnn")

    // 访问元组中的数据
    print(tuple._1)
    print(tuple._2)
    println(tuple._3)

    // 循环遍历
    for (elem <- tuple.productIterator) {
        println(elem)
    }


    // 如果元组中元素的个数为2，那么称之为对偶，类似于Map中的键值对
    val tuple1: (Int, String) = (817, "gql")
    val tupleMap: Map[Int, String] = Map(tuple1)
    println(tuple1)//(817,gql)
    println(tupleMap)//Map(817 -> gql)

    // f: (Int, String) => ()
    tupleMap.foreach(t => println(t._1 + ", " + t._2))
}

class User {
    var username: String = _
    var age: Int = _
}
