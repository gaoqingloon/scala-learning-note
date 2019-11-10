package com.lolo.bigdata.scala.chapter02

object Scala02_DataType {

    def main(args: Array[String]): Unit = {

        // 完全面向对象，没有基本数据类型
        val age: Int = 20

        // byte short int long float double boolean char
        val b: Byte = 10
        val s: Short = 10
        val i: Int = 10
        val l: Long = 10
        // ...

        val d = i.toDouble
        println(d)

        println(Unit)  //object scala.Unit

        val nul: String = null
        println(nul)  // null



    }

    def f1(): Nothing = {
        throw new Exception
    }
}
