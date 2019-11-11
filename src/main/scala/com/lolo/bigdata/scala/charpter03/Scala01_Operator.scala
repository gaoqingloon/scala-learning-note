package com.lolo.bigdata.scala.charpter03

object Scala01_Operator {

    def main(args: Array[String]): Unit = {

        // scala 没有++运算符
        var i: Int = 1
        i += 1
        println(i)

        var j: Byte = 1
        //j += 1 // 运行失败，类型不匹配
        println(j)

        // true / false
        var b = 10
        println(b = 10)  //()

        if (true) {
        //if (b = 10) {  // scala表达式都有结果
            println("true")
        } else {
            println("false")
        }
    }
}
