package com.lolo.bigdata.scala.chapter060708

/**
  * 包
  * 1.相当于多个包的组合，在最后的那个包下
  * 源码中的类所在的位置不需要和包路径相同
  * 2. package可以使用大括号内，作用范围
  * 3. 父包与子包，作用域的概念
  * 4. 包里只能声明类，不能属性和方法
  * 5. 包对象package object中可以声明属性和方法
  */

package test {

    class Emp {

    }

    package object test {
        val test = "110"
        def test1(): Unit = {

        }
    }

    package test1 {
        object Scala02_Package {

            def main(args: Array[String]): Unit = {

                println("Hello World")
                val emp: Emp = new Emp()
                println(emp)
            }
        }
    }
}


