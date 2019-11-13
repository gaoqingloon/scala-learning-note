package com.lolo.bigdata.scala.chapter10

import scala.collection.mutable

/**
  * 映射 Map
  *
  * 采用特殊的方式声明 Map("a" -> 1, "b" -> 2)
  *
  * Scala为了防止集合空指针问题，提供了一个特殊的类，Option有两个特殊的对象 Some，None
  * 如果确实没有获取到数据，为了不出现异常，Option类提供了有默认值的方法 getOrElse
  */
object Scala07_Map extends App {

    // 1. 默认Map集合不可变
    val map: Map[String, Int] = Map("g" -> 9, "q" -> 1, "l" -> 3)
    println(map.mkString(","))//g -> 9,q -> 1,l -> 3

    // 增加数据
    val map1: Map[String, Int] = map + ("n" -> 8)
    println(map1)//Map(g -> 9, q -> 1, l -> 3, n -> 8)
    println(map == map1)//false

    // 删除数据
    println(map - "g")

    // 修改数据
    println(map.updated("l", 7))

    // 查询数据
    println(map.get("q"))//Some(1)
    println(map.get("n"))//None
    println(map.getOrElse("n", "love"))//love


    println("-----------")
    // 2. 可变Map集合
    val mmap: mutable.Map[String, Int] = mutable.Map("g" -> 9, "q" -> 1, "l" -> 3)
    println(mmap.mkString(","))//g -> 9,q -> 1,l -> 3

    val mmap1: mutable.Map[String, Int] = mmap + ("n" -> 8)
    println(mmap1)//Map(g -> 9, q -> 1, l -> 3, n -> 8)

    println(mmap == mmap1)//false

}
