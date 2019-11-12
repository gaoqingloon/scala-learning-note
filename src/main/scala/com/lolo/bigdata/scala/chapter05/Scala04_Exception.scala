package com.lolo.bigdata.scala.chapter05

/**
  * 异常
  */
object Scala04_Exception {

    def main(args: Array[String]): Unit = {

        try {
            val i = 10
            val j = 0
            val k = i / j
        } catch {
            // 顺序重要
            case ex: Exception => println("Exception")
            case ex: ArithmeticException => println("ArithmeticException")
        } finally {
            println("finally...")
        }
    }
}
