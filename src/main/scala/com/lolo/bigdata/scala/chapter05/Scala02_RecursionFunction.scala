package com.lolo.bigdata.scala.chapter05

/**
  * 递归演示
  * 1.函数的逻辑代码中调用自身
  * 2.函数在调用自身时，传递的参数应该有规律
  * 3.函数应该有跳出的逻辑，否则出现死循环
  * 4.递归函数无法推断出函数的返回值类型，所以必须有声明
  */
object Scala02_RecursionFunction {

    def main(args: Array[String]): Unit = {

        // 阶乘：有规律 n*(n-1)
        def !!(i: Int): Int = {
            if (i == 1) {
                1
            } else {
                i * !!(i - 1)
            }
        }

        println(!!(5))



    }
}
