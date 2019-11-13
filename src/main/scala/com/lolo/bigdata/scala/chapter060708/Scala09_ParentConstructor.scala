package com.lolo.bigdata.scala.chapter060708

/**
  * 父类构造方法
  */
object Scala09_ParentConstructor {

    def main(args: Array[String]): Unit = {

        val user: User09 = new User09()
        /*
        Person 主构造方法XXX
        User 主构造方法
        User 辅助构造方法
         */

    }
}

class Person09(s: String) {
    println("Person 主构造方法" + s)
}

// 如果父类主构造方法有参数，那么构建对象时必须显式的传递参数
// 可以在继承的父类后面增加小括号，传递参数，等同于调用父类构造方法
class User09(s: String) extends Person09(s) {
    println("User 主构造方法")

    def this() {
        this("XXX")
        println("User 辅助构造方法")
    }
}
