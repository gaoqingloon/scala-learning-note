package com.lolo.bigdata.scala.chapter04

import scala.util.control.Breaks

/**
  * for while 循环
  */
object Scala03_For {

    def main(args: Array[String]): Unit = {

        for (i <- 0 to 3) { // 0.to(3)
            println(s"i = ${i}") // 0,1,2,3
        }
        println("----------")

        for (i <- 0 until 3) { // 0.until(3)
            println(s"i = ${i}") // 0,1,2
        }
        println("---------")

        for (i <- Range(0, 5, 2)) {
            println(s"i = ${i}") // 0,2,4
        }
        println("---------")

        for (i <- 1 to 3) {
            for (j <- 1 until 3) {
                println(s"i = $i, j = $j")
            }
        }

        // 杨辉三角
        // 九层妖塔
        /*
            *
           ***
          *****
         */
        for (i <- Range(1, 18, 2)) {
            println(" " * ((18 - i) / 2) + "*" * i + " " * ((18 - i) / 2))
        }
        println("----------")

        for (i <- 0 to 3 if i % 2 == 0) {  // continue
            println(s"i = $i") // 0,2
        }
        println("----------")


        Breaks.breakable {
            for (i <- 1 to 10) {
                if (i == 3) {
                    Breaks.break()
                }
                println(s"i = $i")
            }
        }
        println("over")

        var n = 1
        val while1 = while(n <= 10){
            n += 1
        }
        println(while1)  //()
        println(n)  // 11

    }
}
