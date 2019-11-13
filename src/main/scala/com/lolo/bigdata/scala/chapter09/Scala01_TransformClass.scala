package com.lolo.bigdata.scala.chapter09

/**
  * 隐式转换
  *
  * 自动转换 - 隐式转换
  * scala默认的情况下支持数值类型的自动转换
  * byte -> short -> int -> long
  * scala默认的情况下支持多态语法中的类型自动转换
  * child -> parent -> trait(interface)
  *
  * scala也允许开发人员自定义类型转换规则
  * 将两个无关的类型通过编程手段让他们可以自动转换
  *
  */
object Scala01_TransformClass {

    def main(args: Array[String]): Unit = {

        implicit def transform(d: Double): Int = {
            d.toInt
        }

        implicit def transformMySQL(mysql: MySQL): Operator = {
            new Operator
        }

        /*
        在相同的作用域内，不能含有多个相同类型的转换规则
        implicit def transform(d: Double): Int = {
            d.toInt
        }*/

        // OCP = Open Close 对扩展开放，对修改关闭

        val num: Int = 5.0
        println(num)

        val mysql: MySQL = new MySQL()
        mysql.select()
        mysql.delete()
    }
}

class Operator {
    def delete(): Unit = {

    }
}

class MySQL {
    def select(): Unit = {

    }
}
