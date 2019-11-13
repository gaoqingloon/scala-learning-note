package com.lolo.bigdata.scala.chapter060708

/**
  * Author: gordon
  * Email: gordon_ml@163.com
  * Date: 11/12/2019
  * Description: 父类、子类
  * version: 1.0
  */
object Scala08_Class {

    def main(args: Array[String]): Unit = {

        val user: User08 = new User08()
        //user.name
        user.test()
        user.test1()  // child test1...

        val u: Person = new User08()
        u.test1()  // child test1...

        println(user.email)
    }
}

// 声明类，父类，继承
// 类可以声明为抽象的 abstract
abstract class Person {

    var name: String = _
    // scala中属性可以重写，因为属性可以是抽象的
    // 属性只有声明没有初始化，那么就是抽象属性
    // 抽象属性在编译为class文件时，不产生属性，但是产生抽象getter方法
    var sex: String

    //var email: String = "gql@163.com"
    val email: String = "gql@163.com"

    // 声明抽象方法，方法只有声明，没有实现，不需要abstract关键字声明
    def test()

    def test1(): Unit = {
        println("parent test1...")
    }
}

class User08 extends Person {

    // 重写抽象方法：补全方法
    override def test(): Unit = {
        println("test")
    }

    // scala如果子类重写父类的方法（不是抽象），需要增加override关键字
    //override def test1(): Unit = super.test1()
    override def test1(): Unit = {
        println("child test1...")
    }

    // 重写属性
    override var sex = "男"

    // 属性可以被覆盖（重写），但是不能重写父类var声明的变量
    override val email = "gordon_ml@163.com"
}
