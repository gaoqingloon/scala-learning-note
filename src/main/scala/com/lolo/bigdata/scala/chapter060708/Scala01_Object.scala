package com.lolo.bigdata.scala.chapter060708

/**
  * 面向对象
  */
object Scala01_Object {

    def main(args: Array[String]): Unit = {

        // 创建类的对象 alt+t
        val user: User = new User()

        // 调用对象的属性或方法
        user.username = "Sam"
        println(user.username)
    }
}

// 声明类
class User {

    // 声明属性
    var username: String = _
    var age: Int = _

    def login(): Boolean = {
        true
    }
}
