package com.lolo.bigdata.scala.chapter13

/**
  * Author: gordon  Email:gordon_ml@163.com
  * Date: 11/14/2019
  * Description: 泛型
  * Version: 1.0
  */
object Scala01_Generic {

    def main(args: Array[String]): Unit = {

        //test(new Person)
        test(new Child)
        test1(new Child)
    }

    // T: 传递的类型  User: 上限  即范围小于User
    // <: 表示泛型的上限，所以传递数据时，应该为子类或当前类
    // >: 表示泛型的下限，和java不同(父类或当前类)，可以任意传递
    def test[T <: User](t: T): Unit = {
        println(t)
    }

    def test1[T >: User](t: T): Unit = {
        println(t)
    }
}

class Person {

}

class User extends Person {

}

class Child extends User {

}
