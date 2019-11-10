package com.lolo.bigdata.scala.chapter02

object Scala03_Name {

    def main(args: Array[String]): Unit = {

        // 标识符
        // scala中可以使用特殊符号作为标识符，其实是将特殊符号在编译时进行了转换
        val ++ = "123"
        val +-*/ = "456"
        val %@# = "324"
        /*
            String $plus$plus = "123";
            String $plus$minus$times$div = "456";
            String $percent$at$hash = "324";
         */

        //val ++a+ = "243"  // 不可以，符号开头，后必须接符号

        println(++)
        println(+-*/)
        println(%@#)

        // scala中下划线有特殊用途，不能独立当成变量名使用
        //val _ = "123"
        //println(_)  // 编译失败

        val a = "abc" + _
        println(a)  // <function1>

        val `private` = "111"
        println(`private`)
    }
}
