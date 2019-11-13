package com.lolo.bigdata.scala.chapter09

import com.lolo.bigdata.scala.chapter09.Scala03_ImplicitClass.User03

/**
  * 隐式类
  *
  */
object Scala03_ImplicitClass {

    def main(args: Array[String]): Unit = {

        val user: User03 = new User03()
        user.insert()
        user.delete()
        user.update()
    }

    // 会寻找当前类作用域的隐式转换，还会寻找继承的特质中的伴生对象
    class User03 extends Test03 {
        def insert(): Unit = {

        }
    }

    implicit class Person03(u: User03) {
        def delete(): Unit = {

        }
    }
}

trait Test03 {

}
// 伴生对象
object Test03 {
    implicit class Person03(u: User03) {
        def update(): Unit = {

        }
    }
}
