package com.lolo.bigdata.scala.chapter060708

/**
  * 特质顺序
  *
  * 特质和父类没有关系，只和当前混入的类有关系，
  * 所以，在调用时，父类先执行，然后当前混入的特质再执行，然后当前类再执行
  *
  * 如果父类混入了相同的特质，那么特质的代码只会执行一遍
  */
object Scala13_InterfaceOrder {
    def main(args: Array[String]): Unit = {

        val user: User13 = new User13()
    }
}

trait TestTrait13 {
    println("trait code...")
}
class Person13 extends TestTrait13 {
    println("parent code...")
}
class User13() extends Person13 with TestTrait13 {
    println("child code...")
}
/*
trait code...
parent code...
child code...
 */


/*
trait TestTrait13 {
    println("trait code...")
}
class Person13 {
    println("parent code...")
}
class User13() extends Person13 with TestTrait13 {
    println("child code...")
}
*/
/*
parent code...
trait code...
child code...
 */