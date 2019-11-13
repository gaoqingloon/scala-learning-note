package com.lolo.bigdata.scala.chapter060708

import scala.beans.BeanProperty

/**
  * 类的属性
  *
  * 1. 声明属性默认是私有的，但是底层提供了共有的setter和getter方法
  * 2. 属性增加private，底层生成的setter和getter方法都是私有的
  * 3. val声明的属性，底层提供了共有的getter方法，没有提供setter方法
  *
  * 4. scala中有4种访问权限
  * 1) public 是默认的访问权限，没有关键字
  * 2) protected 访问权限只能子类访问，同包访问不了
  * 3) private 私有访问权限，只能当前类访问
  * 4) 包访问权限需要用特殊的语法：private[包名]
  */
object Scala05_Field {

    def main(args: Array[String]): Unit = {

        val user: User05 = new User05()
        // setter
        user.userName = "gordon"
        // getter
        println(user.userName)
        // user.setAddress("shanghai")
        // user.getAddress()

        user.setAge(18)
        println(user.getAge)

        //user.email = "HelloWorld"  // val底层没有setter方法
        println(user.email)

    }
}

class User05 {

    var userName: String = _
    private var age: Int = _  //private属性只能类内部使用
    val email: String = "gordon_ml@163.com"

    def setAge(age: Int): Unit = {
        this.age = age
    }
    def getAge: Int = {
        age
    }

    // 为了和java bean规范统一，scala提供了注解，生成java中对应的set，get方法
    @BeanProperty var address: String = _
}

/**
  * scala中有4种访问权限
  * 1) public 是默认的访问权限，没有关键字
  * 2) protected 访问权限只能子类访问，同包访问不了
  * 3) private 私有访问权限，只能当前类访问
  * 4) 包访问权限需要用特殊的语法：private[包名]
  */
package p1 {
    package p2 {
        class UserP2 {
            var userName = "gordon"
            private var password = "123456"
            protected var email = "gordon_ml@163.com"
            private[p2] var address = "shanghai"
        }
    }

    package p3 {

        import com.lolo.bigdata.scala.chapter060708.p1.p2.UserP2

        class EmpP3 extends UserP2 {
            def test(): Unit = {
                val user: UserP2 = new UserP2()
                println(user.userName)
                // user.address
                //user.email
            }
        }
    }
}

