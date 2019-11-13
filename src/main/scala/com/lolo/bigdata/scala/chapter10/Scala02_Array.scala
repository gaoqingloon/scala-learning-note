package com.lolo.bigdata.scala.chapter10

/**
  * Array 数组（不可变，产生新的）
  *
  * Array(1,2,3,4)
  *
  * Scala中的数据，使用Array对象实现，使用[]声明数组类型: Array[String]
  * Scala可以使用简单的方式创建数组
  * apply
  */
object Scala02_Array {

    def main(args: Array[String]): Unit = {

        // 1.创建数组
        val arr1: Array[Int] = Array(1,2,3,4)

        // 2.访问数组，使用 数组名(索引)
        println(arr1(0))
        println(arr1.length)
        println(arr1)  //[I@1b40d5f0

        // 3.将数组转换为字符串打印出来
        println(arr1.mkString("|"))

        // 4.遍历数组
        for (elem <- arr1) {
            println(elem)
        }

        def printlnXXX(i: Int): Unit = {
            print(i + "\t")
        }
        // 5.foreach方法会将数组中的每个元素进行循环遍历，执行指定函数实行逻辑
        // f ()
        arr1.foreach(printlnXXX)

        arr1.foreach((i: Int) => {println(i)})
        arr1.foreach((i) => {println(i)})
        arr1.foreach({println(_)})
        arr1.foreach(println(_))
        arr1.foreach(println)

        // 6.修改数据 update
        arr1.update(1, 5)
        println(arr1.mkString("|"))

        // 7.增加元素，产生新的数组（不可变数组）
        val arr2: Array[Int] = arr1 :+ 5  //尾加
        val arr3: Array[Int] = 5+:arr1  //头加

        println(arr2.mkString("|")) //1|5|3|4|5
        println(arr3.mkString("|")) //5|1|5|3|4
        println(arr1 == arr2)  //false
    }
}
