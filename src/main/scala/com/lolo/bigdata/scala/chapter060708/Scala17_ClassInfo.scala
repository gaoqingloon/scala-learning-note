package com.lolo.bigdata.scala.chapter060708

/**
  * 类信息
  *
  * java:
  *     User19.class
  *     Object.getClass
  *     ==> Class
  * 类.class = classOf[类]
  * 对象 instanceof 类B  =  对象.isInstanceOf[类B]
  * (类A) 对象  =  对象.asInstanceOf[类A]
  *
  * scala如果想要获取类的信息，需要采用特殊的方法：classOf[类型]
  * classOf能直接使用，因为scala.Predef伴生对象是默认导入到当前开发环境中
  */
object Scala17_ClassInfo {

    def main(args: Array[String]): Unit = {

        val userClass: Class[User17] = classOf[User17]
        userClass.getInterfaces

        // 可以是使用type关键字给类起别名
        type XXX = User17
        val user: XXX = new XXX()

        // 判断类型
        val bool: Boolean = user.isInstanceOf[XXX]
        if (bool) {
            // 转换类型
            val user1: XXX = user.asInstanceOf[XXX]
            println(user1)
        }
    }
}

class User17 {

}
