package com.lolo.bigdata.scala.charpter05

/**
  * 函数式编程
  * Scala语法灵活，任意的语法中可以声明其他语法规则
  */
object Scala01_Function {

    def main(args: Array[String]): Unit = {

        // 面向对象：对象关系，继承，实现，重写，多态
        // 面向函数：函数的功能，入参和返回值

        // 函数声明
        def test(s: String): Unit = {
            // 函数体
            println(s)
        }
        test("zhangsan")

        def test1(): Unit = {
            println("HelloWorld")
        }
        test1()

        def test2(s: String): String = {
            s + "..."
        }
        println(test2("lisi"))

        def test3(): String = {
            "wangwu...."
        }
        println(test3())

        def test4() = {
            "zhaoliu...."
        }
        println(test4())

        def test5() = "tianqi...."
        println(test5())

        def test6 = "zhaoba...."
        println(test6)  // 调用不是test6()

        def test7() {
            "tianqi...."
        }
        println(test7())  // ()


        ////////////////////////////

        def f(): Unit = {
            println("func")
        }
        def f0() = {
            // 返回函数需要加 _
            f _
        }
        f0()()

        // 简化上面的函数：函数嵌套
        def f1() = {
            def f2(): Unit = {
                println("func1")
            }
            f2 _
        }
        f1()()

        // 函数嵌套，每个函数有入参：闭包
        // 一个函数在实现逻辑时，将外部的变量引入到函数的内容，改变了这个变量的声明周期，称之为闭包
        def f3(i: Int) = {
            def f4(j: Int): Int = {
                println("func2")
                i * j // 改变了外部变量的生命周期，放到内部，不能回收外部变量
            }
            f4 _
        }
        println(f3(3)(4))

        // 简化上面的函数：函数柯里化（柯里化就是依靠闭包实现的）
        def f5(i: Int)(j: Int) = {
            println("func3")
            i * j
        }
        println(f5(3)(5))


        // 将函数作为参数传递给另外一个函数，需要采用特殊的声明方式
        def ff4(f: () => Int): Int = {
            f() + 10
        }
        def ff5(): Int = {
            5
        }
        println(ff4(ff5))

        // 改善上面的代码：匿名函数
        def ff6(f: () => Unit): Unit = {
            f()
        }
        ff6(() => println("Hello"))

    }
}
