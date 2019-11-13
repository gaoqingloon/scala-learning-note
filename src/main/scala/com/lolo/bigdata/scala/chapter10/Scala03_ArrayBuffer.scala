package com.lolo.bigdata.scala.chapter10

import scala.collection.mutable
import scala.collection.mutable._

/**
  * ArrayBuffer: 可变数组 scala.collection.mutable._
  *
  * ArrayBuffer(1, 2, 3, 4)
  */
object Scala03_ArrayBuffer extends App {

    val arrBuffer: ArrayBuffer[Int] = ArrayBuffer(1, 2, 3, 4)

    // 1.查询值
    println(arrBuffer(0))

    // 2.修改值
    arrBuffer(0) = 9
    println(arrBuffer.mkString(","))//9,2,3,4

    // 3.指定位置增加数据
    arrBuffer.insert(3, 6)
    println(arrBuffer.mkString(","))//9,2,3,6,4

    // 4.增加数据
    val arrBuffer1: ArrayBuffer[Int] = arrBuffer.+=(7)
    println(arrBuffer.mkString(","))//9,2,3,6,4,7
    println(arrBuffer1.mkString(","))//9,2,3,6,4,7

    println(arrBuffer == arrBuffer1)//true

    // 5.删除数据，删除指定元素
    val arrBuffer2: ArrayBuffer[Int] = arrBuffer.-=(6)
    println(arrBuffer.mkString(","))//9,2,3,4,7
    println(arrBuffer2.mkString(","))//9,2,3,4,7
    println(arrBuffer == arrBuffer2)//true

    // 5.删除数据，通过索引删除，返回值
    val num: Int = arrBuffer.remove(1)
    println(num)
    println(arrBuffer.mkString(","))//9,3,4,7

    // 6.删除数据，通过索引删除多少个元素，无返回值
    arrBuffer.remove(1, 2)
    println(arrBuffer.mkString(","))//9,7
    for (elem <- arrBuffer) {
        print(elem)
    }
    arrBuffer.foreach(print)
    println()


    // 7. 可变数组与不可变数组的转换
    // arr.toBuffer
    // arrBuffer.toArray
    val arr = Array(5, 7, 8)
    val buffer: mutable.Buffer[Int] = arr.toBuffer
    val array: Array[Int] = arrBuffer.toArray

}
