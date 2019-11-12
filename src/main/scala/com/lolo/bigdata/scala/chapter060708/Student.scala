package com.lolo.bigdata.scala.chapter060708

/**
  * 伴生对象与伴生类
  * scala 中没有静态的语法，所以class中只能写成员属性和成员方法
  * 那么静态的属性和方法就放在 伴生对象中
  */

/**
  * 伴生类（成员）
  */
class Student {

    private val sname = "gordon"
}

/**
  * 伴生对象（静态）
  * 1. 可以访问伴生类中的私有属性
  * 2. 可以创建伴生类对象，需要提供apply方法，实现相应的功能
  */
object Student {

    def apply: Student = new Student()
    def apply(s: String): Student = new Student()

    def test(): Unit = {
        new Student().sname
    }
}
