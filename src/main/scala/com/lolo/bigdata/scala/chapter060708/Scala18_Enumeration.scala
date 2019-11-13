package com.lolo.bigdata.scala.chapter060708

/**
  * 枚举
  */
object Scala18_Enumeration extends App {

    println("HelloWorld")
    println(Color.BLUE)
}

object Color extends Enumeration {
    val RED: Value = Value(1, "red")
    val BLUE: Value = Value(2, "blue")
}
