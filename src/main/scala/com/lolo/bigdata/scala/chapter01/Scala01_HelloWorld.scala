package com.lolo.bigdata.scala.chapter01

object Scala01_HelloWorld {

    // scala源码中包含了main方法，在编译后自动形成了 public static void main
    // scala在编译源码时，会生成两个字节码文件，静态main方法执行另外一个字节码文件中的成员main方法
    // scala是完全面向对象的语言，那么没有静态的语法，只能通过模拟生成静态方法
    // 编译时将当前类生成一个特殊的类 ==> Scala01_HelloWorld$，然后创建对象来调用这个对象的main方法

    // 一般情况下，将加$的类的对象，称之为“伴生对象”
    // 伴生对象中的内容，都可以通过类名访问，来模拟java中的静态语法

    // 伴生对象的语法规则：使用object声明

    // public static void main(String-= arrays) { 方法体 }

    /*
        scala中没有public关键字，默认所有的访问权限都是公共的。
        scala中没有void关键字，采用特殊的对象模拟：Unit
        scala中声明方法采用关键字def
        方法后面的小括号是方法的参数列表
        scala中参数列表的声明方式和java不一样
        java： String 参数名
        scala： 参数名: 类型

        java中方法的声明和方法体直接连接
        scala中方法的声明和方法体通过等号连接

        scala中将方法的返回值类型放置在方法声明的后面使用冒号连接
    */

    def main(args: Array[String]): Unit = {
        println("Hello World")

        // 通过类名调用方法，说明object会产生伴生对象
        Scala01_HelloWorld.test()
    }

    def test(): Unit = {

    }
}
