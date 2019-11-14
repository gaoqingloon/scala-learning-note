package com.lolo.bigdata.scala.chapter10

import scala.io.{BufferedSource, Source}

/**
  * 从文件中读取数据
  *
  */
object Scala11_WordCountFile {

    def main(args: Array[String]): Unit = {

        Source.fromFile("").getLines().toList

        //
        val source: BufferedSource = Source.fromFile("in/word.txt")
        val lines: Iterator[String] = source.getLines()
        val lineWords: List[String] = lines.toList
        //....
    }
}
