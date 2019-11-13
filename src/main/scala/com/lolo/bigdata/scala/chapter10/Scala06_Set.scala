package com.lolo.bigdata.scala.chapter10

import scala.collection.mutable

/**
  * Set 集合
  */
object Scala06_Set extends App {

    // 1. 默认不可变集合 Set
    val set: Set[Int] = Set(9, 1, 3, 8, 1, 7)

    println(set)//Set(1, 9, 7, 3, 8)
    println(set.mkString(","))//1,9,7,3,8

    println(set + 11)//Set(1, 9, 7, 3, 11, 8)
    println(set - 3)//Set(1, 9, 7, 8)


    // 2. 可变Set
    val mset: mutable.Set[Int] = mutable.Set(1, 0, 0, 2, 9, 1, 3)

    println(mset)//Set(0, 9, 1, 2, 3)
    println(mset.mkString(","))//0,9,1,2,3

}
