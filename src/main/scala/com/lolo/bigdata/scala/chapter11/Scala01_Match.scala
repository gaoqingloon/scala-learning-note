package com.lolo.bigdata.scala.chapter11

/**
  * 模式匹配
  */
object Scala01_Match extends App {

    val operator = '/'
    val n1 = 20
    val n2 = 10
    var res = 0
    operator match {
        case '+' => res = n1 + n2
        case '-' => res = n1 - n2
        case '*' => res = n1 * n2
        case '/' => res = n1 / n2
        case _ => println("operator error")
    }
    println(s"res = $res")


    // 在某种情况下，加条件，把有条件的放在相同匹配的前面
    for (ch <- "+-3!") {
        var sign = 0
        var digit = 0
        ch match {
            case '+' => sign = 1
            case '-' => sign = -1
            case _ if ch.toString.equals("3") => digit = 3
            case _ => sign = 2
        }
        println(ch + " " + sign + " " + digit)
    }


    val a = 5
    val obj =
        if (a == 1) 1
        else if (a == 2) "2"
        else if (a == 3) BigInt(3)
        else if (a == 4) Map("aa" -> 1)
        else if (a == 5) Map(1 -> "aa")
        else if (a == 6) Array(1, 2, 3)
        else if (a == 7) Array("aa", 1)  //Array[Any]
        else if (a == 8) Array("aa")

    val result = obj match {
        case a: Int => a
        case b: Map[String, Int] => "对象是一个字符串-数字的Map集合"
        case c: Map[Int, String] => "对象是一个数字-字符串的Map集合"
        case d: Array[String] => "对象是一个字符串数组"
        case e: Array[Int] => "对象是一个数字数组"
        case f: BigInt => Int.MaxValue
        case _ => "啥也不是"
    }
    println(result)//对象是一个字符串-数字的Map集合(注意问题)


    for (arr <- Array(Array(0), Array(1, 0), Array(1, 1, 0), Array(1, 1, 0, 1))) {
        val result = arr match {
            case Array(0) => "0"
            case Array(x, y) => x + "=" + y
            case Array(0, _*) => "以0开头的数组"
            case _ => "什么都不是"
        }
        println(s"result = $result")
    }


    // 列表匹配
    for (list <- Array(List(0), List(1, 0), List(0, 0, 0), List(1, 0, 0))) {
        val result = list match {
            case 0 :: Nil => "0"
            case x :: y :: Nil => x + "=" + y
            case 0 :: tail => "0 ..."
            case _ => "something else"
        }
        println(s"result = $result")
    }


    // 元组匹配
    for (pair <- Array((0, 1), (1, 0), (2, 1), (1, 0, 2))) {
        val result = pair match {
            case (0, _) => "0 ..."
            case (y, 0) => y
            case (a, b) => (b, a)
            case _ => "other"
        }
        println(s"result = $result")
    }


    // 对象匹配
    object Square {
        def unapply(z: Double): Option[Double] = Some(math.sqrt(z))
        def apply(z: Double): Double = z * z
    }
    //val resultSquare = Square(6)//36
    // 模式匹配使用
    val number: Double = 36.0
    number match {
        case Square(n) => println(n)
        case _ => println("nothing matched")
    }


    // 特殊的模式匹配
    val (x, y) = (1, 2)
    val (username, age, email) = ("gordon", 18, "gordon@163.com")
    val (q, r) = BigInt(10) /% 3
    val list3 = List(("a", 1), ("b", 2), ("c", 3))
    println(s"x = $x , y = $y")
    println(s"username = $username, age = $age, email = $email")
    println(s"q = $q , r = $r")//q = 3 , r = 1
    for ((k, v) <- list3) {
        println(k + ": " + v)
    }


    /** _ 的注意事项1 */
    val list1 = List(List(1, 2), List(3, 4))
    //val flatList: List[Int] = list1.flatMap(x => x)
    /*def test(list: List[Int]): List[Int] = {
        list
    }
    val flatList: List[Int] = list1.flatMap(test)*/
    val flatList: List[Int] = list1.flatten
    // 错误的写法_不能识别,推断不出来，默认为函数：
    // val flatList: List[Int] = list1.flatMap(_)
    println(flatList)

    /** _ 的注意事项2 */
    val list2 = List("Hello World", "Hello Scala")
    val wordList: List[String] = list2.flatMap(x => x.split(" "))
    // 此处可以使用_，因为split可以推断出是每个元素
    val wordList1: List[String] = list2.flatMap(_.split(" "))
    println(wordList)
    println(wordList1)

}
