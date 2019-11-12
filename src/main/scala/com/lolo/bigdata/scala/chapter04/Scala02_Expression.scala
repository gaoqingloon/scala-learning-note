package com.lolo.bigdata.scala.chapter04

/**
  * 表达式测试
  */
object Scala02_Expression {

    def main(args: Array[String]): Unit = {

        // scala中所有的表达式都有值
        val flag = true

        // true: String
        // false: Unit
        // 条件分支的返回值的类型不推荐写，类型不一定
        val value: Any = if (flag) {
            "abc"
        }
        println(value)

        val v2 = if (flag) {
            "abc"
            println("abc")
        } else {
            "bcd"
        }
        println(v2)

        // 三元
        val s = if (2 > 1) "a" else "b"
        println(s)
    }
}
