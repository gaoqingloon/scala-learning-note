package com.lolo.bigdata.scala.chapter060708

/**
  * 特质
  *
  * java中的结构无法直接构建对象，必须使用实现类
  * java中的结构是可以声明方法的，早期版本中声明的方法都是抽象的，新版本可以有默认实现
  * java中的结构是可以声明属性的，属性值无法修改
  *
  * scala中的特质也无法构建对象
  * scala中的特质可以执行代码
  * scala特质中声明的属性和方法都可以在混入的类中调用
  */
object Scala12_InterfaceBody {

    def main(args: Array[String]): Unit = {

        val user: User12 = new User12()
        println(user.username)
        user.test()
        user.test1()
    }
}

trait TestTrait12 {
    println("machine learning")
    val username: String = "gordon"
    // 特质中可以声明方法
    def test(): Unit = {
        println("test...")
    }
    // 特质中声明抽象方法
    def test1()
}

class Person12 {

}

class User12() extends Person12 with TestTrait12 {
    // 实现特质中的抽象方法
    override def test1(): Unit = {
        println("test1...")
    }
}
