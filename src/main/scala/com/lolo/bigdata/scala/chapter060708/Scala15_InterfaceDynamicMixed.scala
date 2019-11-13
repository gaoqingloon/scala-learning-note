package com.lolo.bigdata.scala.chapter060708

/**
  * 动态混入特质： with 特质名
  * val mysql = new MySQL15() with Operate15
  */
object Scala15_InterfaceDynamicMixed {

    def main(args: Array[String]): Unit = {

        //val msyql: MySQL15 = new MySQL15()

        // 动态混入特质： new 类名 with 特质
        //val mysql = new MySQL15() with Operate15
        val mysql: MySQL15 with Operate15 = new MySQL15() with Operate15
        mysql.insert()
    }
}

// 待混入的特质
trait Operate15 {
    def insert(): Unit = {
        println("插入数据")
    }
}

//class MySQL15 extends Operate15 { //不允许这样修改(OCP代码开发原则)
class MySQL15 {

}
