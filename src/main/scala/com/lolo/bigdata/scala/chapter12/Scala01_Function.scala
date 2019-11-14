package com.lolo.bigdata.scala.chapter12

/**
  * 偏函数
  *
  * 模式匹配与偏函数的搭配
  * 柯里化和隐式转换搭配使用，因为隐式转换只能针对一个输入参数
  *
  * map 方法不能执行偏函数操作，因为必须对所有的数据进行转换，不能只对其中一部分数据做操作
  * collect 方法支持偏函数，收集满足条件的数据
  */
object Scala01_Function {

    def main(args: Array[String]): Unit = {

        val list = List(1, 2, 3, 4, "abc")

        // 数据分类型问题 isInstanceOf[]
        val list1: List[AnyVal] = list.map(x => {
            if (x.isInstanceOf[Int]) {
                // 此时的x仍然是Any类型
                x.asInstanceOf[Int] + 1
            }
        })
        val filterList = list1.filter(x => x.isInstanceOf[Int])
        println(filterList)


        // 说明
        val addOne = new PartialFunction[Any, Int] {
            override def isDefinedAt(x: Any): Boolean = {
                if (x.isInstanceOf[Int]) true
                else false
            }
            override def apply(v1: Any): Int = {
                v1.asInstanceOf[Int] + 1
            }
        }
        val list2: List[Int] = list.collect(addOne)
        //val list3: List[Int] = list.map(addOne)
        println(s"list2 = ${list2}")
        //println(s"list3 = ${list3}")

        // 偏函数简化，写在{}内部
        val list4: List[Int] = list.collect {
            case num: Int => num + 1
        }
        println(list4)

        val list5: List[AnyVal] = list.map {
            case num: Int => num + 1
            case _ =>
        }.filter(_.isInstanceOf[Int])
        println(list5)

        list.sortWith {
            case (left, right) => left.toString > right.toString
        }
    }
}
