package com.lolo.bigdata.scala.charpter04

/**
  * 程序的流程控制
  */
object Scala01_Process {

    def main(args: Array[String]): Unit = {

        // 单分支
        val flag = true
        if (flag) {
            println("true")
        }

        // 双分支
        if (!flag) {
            println("true")
        } else {
            println("false")
        }

        // 多分支
        // 字符串可以使用双等号比较，但是一般是采用equals比较
        val s: String = "a"
        if ("a".equals(s)) {
            println("hello")
        } else if ("b".equals(s)) {
            println("world")
        } else {
            println("hello world")
        }
    }
}
