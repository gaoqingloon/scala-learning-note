package com.lolo.bigdata.scala.chapter13

/**
  * Author: gordon  Email:gordon_ml@163.com
  * Date: 11/14/2019
  * Description: Scala中，为了丰富泛型的功能，提供了协变(+补充功能)，逆变(-减少功能)类型操作
  * Version: 1.0
  */
object Scala02_Generic2 {

    def main(args: Array[String]): Unit = {

        // List<User2> list = new ArrayList<>();

        // 默认情况下，scala中的泛型和java中一样，泛型不变性
        // scala中，为了丰富泛型的功能，提供了协变(+补充功能)，逆变(-减少功能)类型操作
        val test: Test[User2] = new Test[Child2]
        //val test2: Test[User2] = new Test[Person2]  //报错

        //val test3: Test2[User2] = new Test2[Child2]  //报错
        val test4: Test2[User2] = new Test2[Person2]

        println(test)
        println(test4)


        // 泛型代码中的使用
        val ints: List[Int] = List(1, 2, 3, 4)
        // f: (B, Int) => B   f: (User2, Int) => User2
        //ints.reduceLeft[User2]()

    }
}

class Person2 {

}

class User2 extends Person2 {

}

class Child2 extends User2 {

}

//协变(+补充功能)
class Test[+User2] {

}
//逆变(-减少功能)
class Test2[-User2] {

}
