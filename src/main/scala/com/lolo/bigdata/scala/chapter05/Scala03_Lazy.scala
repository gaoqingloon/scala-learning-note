package com.lolo.bigdata.scala.chapter05

/**
  * 延迟加载
  */
object Scala03_Lazy {

    def main(args: Array[String]): Unit = {

        lazy val res = sum(10, 2)
        println("--------")
        println("--------")
        println("--------")
        println("res = " + res)

        /*
            --------
            --------
            --------
            sum() 执行了 // 用的时候才执行函数
            res = 12
         */
    }

    def sum(x: Int, y: Int): Int = {
        println("sum() 执行了")
        x + y
    }
}
