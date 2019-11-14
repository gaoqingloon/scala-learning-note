package com.lolo.bigdata.scala.chapter10

import java.util

import scala.collection.mutable.ArrayBuffer

/**
  * Scala数组和java的list互转
  */
object Scala12_ScalaToJava extends App {

    val arr = ArrayBuffer("1", "2", "3")

    // scala -> java
    import scala.collection.JavaConversions.bufferAsJavaList
    val javaArr = new ProcessBuilder(arr)
    val arrList: util.List[String] = javaArr.command()
    println(arrList)  //[1, 2, 3]

    // java -> scala
    // java.util.List ==> Buffer
    import scala.collection.JavaConversions.asScalaBuffer
    import scala.collection.mutable
    val scalaArr: mutable.Buffer[String] = arrList
    scalaArr.append("jack")
    println(scalaArr)  //ArrayBuffer(1, 2, 3, jack)
}
