package com.lolo.bigdata.scala.chapter10

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * 可变序列 ListBuffer
  *  import scala.collection.mutable.ListBuffer
  */
object Scala05_ListBuffer extends App {

    val listBuffer: ListBuffer[Int] = ListBuffer(9, 1, 3)

    //listBuffer.insert()
    //listBuffer.drop()
    //listBuffer.remove()
    //listBuffer.updated()
    for (elem <- listBuffer) {
        print(elem + "\t")
    }
    println()
    listBuffer.foreach(print)
    println()
    println(listBuffer.mkString(","))


    // 集合的属性
    // 头
    println(listBuffer.head)//9
    // 尾
    println(listBuffer.tail)//ListBuffer(1, 3)
    // 最后一个
    println(listBuffer.last)//3
    // 初始化，除了最后一个
    println(listBuffer.init)//ListBuffer(9, 1)


    // 队列（一定可变）
    val queue: mutable.Queue[Int] = mutable.Queue(8, 1, 7)

    queue.enqueue(5)
    println(queue)//Queue(8, 1, 7, 5)

    println(queue.dequeue())//8
    println(queue)//Queue(1, 7, 5)

}
