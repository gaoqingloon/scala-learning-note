package com.lolo.bigdata.scala.chapter10

/**
  * Seq 序列
  *
  * 默认scala提供的集合都是不可变的
  */
object Scala04_List extends App {

    val list: List[Int] = List(3, 4, 2, 1)
    val list1: List[Int] = List(2, 5, 1, 6)

    // 1. 获取元素
    println(list(3))
    println(list.head) //3
    println(list.tail) //List(4, 2, 1)

    // 2. 添加元素
    // list中的冒号运算符顺序从右到左
    val list2: List[Int] = list:+6
    println(list2.mkString(","))
    println(list == list2)  //false

    val list3: List[Int] = list ++ list1
    println(list3.mkString(","))

    val list4: List[Int] = list.::(9)
    val list5: List[Int] = 9 :: list
    println(list4.mkString(","))//9,3,4,2,1
    println(list5.mkString(","))//9,3,4,2,1

    println(list1.mkString(","))//2,5,1,6
    println(list.mkString(","))//3,4,2,1
    val list6: List[Any] = 8 :: list1 :: list//冒号运算符顺序从右到左
    val list7: List[Any] = 8 :: list1 ::: list
    println(list6.mkString(","))//8,List(2, 5, 1, 6),3,4,2,1
    println(list7.mkString(","))//8,2,5,1,6,3,4,2,1

    // 3. 特殊集合：空集合
    println(List())//List()
    println(Nil)//List()
    println(1 :: 2 :: 3 :: Nil)//List(1, 2, 3)

    // 4. 修改元素
    println(list.mkString(","))//3,4,2,1
    println(list.updated(2, 5).mkString(","))//3,4,5,1
    println(list.mkString(","))//3,4,2,1

    // 5. 删除元素 drop(n) 删除n个元素
    println(list.mkString(","))//3,4,2,1
    println(list.drop(2).mkString(",")) //2,1
    println(list.mkString(","))//3,4,2,1
}
