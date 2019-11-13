package com.lolo.bigdata.scala.chapter060708

/**
  * 构造器参数
  */
object Scala10_ConstructorParam {

    def main(args: Array[String]): Unit = {

        val user: User10 = new User10("gordon")
        println(user.name)
    }
}

// 类构造方法的参数的作用域默认为整个类的主体，但是如果想要参数作为属性来使用，
// 可以采用特殊方式声明 var / val
class User10(var name: String) {

    // var name: String = name
}
