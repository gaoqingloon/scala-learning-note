package com.lolo.bigdata.scala.chapter060708

/**
  * 特质继承类
  */
object Scala16_InterfaceWithException {

    def main(args: Array[String]): Unit = {

        val mysql: MySQL16 = new MySQL16()
        mysql.getMessage()
        //mysql.insert()

    }
}

// 特质继承类
/*trait Operate16 extends Exception {
    def insert(): Unit = {
        println("插入数据")
        this.getMessage()
    }
}*/

// 没有继承，可以在内部限制父类范围
trait Operate16 {

    // 特质使用的范围
    this: Exception =>
    def insert(): Unit = {
        println("插入数据")
        this.getMessage()
    }
}

class MySQL16 extends Exception with Operate16 {

}
