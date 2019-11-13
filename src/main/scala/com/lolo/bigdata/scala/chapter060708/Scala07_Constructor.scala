package com.lolo.bigdata.scala.chapter060708

/**
  * 构造方法
  * 1. 主构造方法（类后声明的构造方法）
  * 2. 辅助构造方法（主构造方法中声明的构造方法）
  * 3. 可以通过辅助构造方法创建对象，但是必须调用主构造方法
  * 类是函数，可以使用小括号作为函数的参数列表
  * 类所代表的函数其实就是这个类的构造方法
  * 默认情况下，scala也是类提供无参构造方法，所以小括号可以省略
  */
object Scala07_Constructor {

    def main(args: Array[String]): Unit = {

        //val user: User07 = new User07("gordon")
        //println(user)

        val user: User07 = new User07()
        println(user)
        /*
        主构造方法
        辅助构造方法1
        辅助构造方法2
         */
    }
}

class User07(s: String) {
    // 类体，构造方法体
    println("主构造方法")
    println(s)

    // 声明辅助构造方法，方法名为this
    // 构造方法调用其他的构造方法时，应该保证被调用的构造方法已经声明过
    def this(s: String, s2: String) {
        this(s)
        println("辅助构造方法2")
    }

    def this() {
        this("辅助构造方法1", "xxx")
    }
}
