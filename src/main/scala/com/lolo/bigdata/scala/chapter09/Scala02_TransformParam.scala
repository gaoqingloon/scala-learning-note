package com.lolo.bigdata.scala.chapter09

/**
  * 隐式转换 - 隐式参数
  *
  * 本质：转换的是类型，类型之间的转换，因此不可以重复
  * 如果隐式参数存在默认值以及对应类型的隐式值，那么会优先采用隐式值，
  * 如果找不到，那么会使用默认值，如果没有默认值，那么会发生错误
  */
object Scala02_TransformParam {

    def main(args: Array[String]): Unit = {

        def test(name: String = "gordon"): Unit = {
            println("Hello " + name)
        }
        //test  //不可以省略
        test()
        test("gql")
        println("-------------")


        // 隐式参数
        def testImplicit(implicit name: String = "gordon"): Unit = {
            println("Hello " + name)
        }
        // 隐式值
        implicit val username: String = "lnn"

        //方法调用时，不使用()可以传递隐式值
        testImplicit  //Hello lnn
        //方法调用时，使用()会导致隐式值无法传递
        testImplicit()  //Hello gordon
        testImplicit("gql")  //Hello gql
    }
}
