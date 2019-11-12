package com.lolo.bigdata.scala.chapter060708

/**
  * 类的方法
  *
  * 所谓的方法，其实就是类中声明的函数，所以声明方式和函数是一样的，调用方式有区别
  */
object Scala06_Method {

    def main(args: Array[String]): Unit = {

        val user: User06 = new User06()
        //user.login()
        //user.clone()

        //val str: String = user.+("xxx")
        //user + "xxx"
        //println(str)


        // 使用伴生对象创建伴生类
        val student: Student.type = Student
        println(student)

        val stu: Student = Student("gordon")
        println(stu)

        //
        val range: Range = Range(1, 5)
        println(range)
    }
}

class User06 {
    def login(): Unit = {

    }

    def logout(): Unit = {

    }
}
