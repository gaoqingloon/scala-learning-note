package com.lolo.bigdata.scala.chapter03

import scala.io.StdIn

/**
  * 从键盘输入
  */
object Scala02_KeyboardIn {

    def main(args: Array[String]): Unit = {

        print("请输入任意字符：")
        val line: String = StdIn.readLine()
        println(line)
    }
}
