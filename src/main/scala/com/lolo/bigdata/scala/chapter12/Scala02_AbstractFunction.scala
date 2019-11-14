package com.lolo.bigdata.scala.chapter12

import scala.util.control.Breaks

/**
  * 函数抽象
  *
  * 函数作为参数传递给另外一个函数，如果这个函数不需要参数，也不需要返回值，
  * 那么可以直接传递代码逻辑 声明方式 => Unit
  */
object Scala02_AbstractFunction {

    def main(args: Array[String]): Unit = {

        /*Breaks.breakable {
            for () {

            }
        }*/

        // 没有输入，没有返回值，只传递逻辑：控制抽象
        def test(f: => Unit): Unit = {
            f
        }
        test {
            println("Hello World")
        }

        def test1(b: Boolean)(f: => Unit): Unit = {
            if (b) f
            else println("No")
        }
        test1(b = false)({println("Hello Scala")})
    }
}
