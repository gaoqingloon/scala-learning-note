package com.lolo.bigdata.scala.chapter060708

/**
  * 特质方法执行顺序
  *
  * 多特质混入时，代码执行从左到右，如果有父特质，会优先执行
  * 多特质混入时，方法调用顺序从右到左
  * 特质中super关键字不是指代父特质，指代的是上一级特质
  * 如果希望super指向父特质，需要增加特殊操作 super[特质名]
  * java的接口可以在scala中当成特质来用
  */
object Scala14_InterfaceMethodOrder {

    def main(args: Array[String]): Unit = {

        val mysql: MySQL = new MySQL()
        mysql.insert()
    }
}

trait Operate {
    println("Operate...")
    def insert(): Unit = {
        println("插入数据")
    }
}

trait DB extends Operate {
    println("DB...")
    override def insert(): Unit = {
        print("向数据库")
        super.insert()
    }
}

trait File extends Operate {
    println("File...")
    override def insert(): Unit = {
        print("向文件")
        super[Operate].insert()  //向文件插入数据
    }
}

class MySQL extends DB with File with Serializable {

}
/*
Operate...
DB...
File...
向文件向数据库插入数据
 */
