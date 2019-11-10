package com.lolo.bigdata.scala.chapter01

/**
  * 打印字符串
  */
object Scala02_StringPrint {

    def main(args: Array[String]): Unit = {

        val name = "gql"
        val age = 18
        val url = "www.gql.com"

        println("name = " + name + ", age = " + age + ", url = " + url)
        print("name = " + name + ", age = " + age + ", url = " + url + "\n")
        printf("name = %s, age = %d, url = %s\n", name, age, url)
        // 插值字符串
        println(s"name = $name, age = $age, url = $url")
        print(f"name = $name, age = ${age}%.2f, url = $url\n")
        print(raw"name = $name, age = $age, url = $url\n")
    }
}
