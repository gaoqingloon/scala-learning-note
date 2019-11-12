package com.lolo.bigdata.scala.chapter03

/**
  * 交换两个数值
  */
object Scala03_Swap {

    def main(args: Array[String]): Unit = {

        var a: Int = 10
        var b: Int = 20
        println(s"a = $a, b = $b")

        val tmp = a
        a = b
        b = tmp
        println(s"a = $a, b = $b")

        a = a + b
        b = a - b
        a = a - b
        println(s"a = $a, b = $b")

        a = a ^ b  // 30
        b = a ^ b  // 10
        a = a ^ b  // 20
        println(s"a = $a, b = $b")
    }
}
