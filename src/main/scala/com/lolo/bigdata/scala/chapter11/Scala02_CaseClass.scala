package com.lolo.bigdata.scala.chapter11

/**
  * 样例类
  * case class
  */
object Scala02_CaseClass {

    def main(args: Array[String]): Unit = {

        //val dollar = new Dollar(1.0)
        //val dollar = Dollar(1.0)
        //println(dollar.value)

        for (amt <- Array(Dollar(1000.0), Currency(1000.0, "RMB"), NoAmount)) {
            val result = amt match {
                case Dollar(v) => "$" + v
                case Currency(v, u) => v + " " + u
                case NoAmount => ""
            }
            println(amt + ": " + result)
        }
        /*
        Dollar(1000.0): $1000.0
        Currency(1000.0,RMB): 1000.0 RMB
        NoAmount:
         */
    }
}

// sealed 密封类，必须放在一个文件中
abstract sealed class Amount
case class Dollar(value: Double) extends Amount
case class Currency(value: Double, unit: String) extends Amount
case object NoAmount extends Amount
