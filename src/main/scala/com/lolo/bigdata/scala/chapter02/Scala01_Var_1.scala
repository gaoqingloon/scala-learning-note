package com.lolo.bigdata.scala.chapter02

object Scala01_Var_1 {

    def main(args: Array[String]): Unit = {

        // 能省则省，为了让开发过程简单，自动推断的可以省略
        // 习惯加上查看更明确
        val username: String = "gql"
        val address = "shanghai"

        println(s"$username, $address")

        val dog = new Dog()
        dog.name = "Pao"
        println(dog.name)
    }
}

class Dog {
    // var类型可以改变
    var name: String = ""
}
