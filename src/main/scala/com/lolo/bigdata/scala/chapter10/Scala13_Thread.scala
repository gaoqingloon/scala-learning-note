package com.lolo.bigdata.scala.chapter10

/**
  * 线程池
  */
object Scala13_Thread {

    def main(args: Array[String]): Unit = {

        val res1 = (0 to 10).map({case _ => Thread.currentThread().getName})
        val res2 = (0 to 10).par.map({case _ => Thread.currentThread().getName})
        println(res1)
        println(res2)
        /*
Vector(main, main, main, main, main, main, main, main, main, main, main)
ParVector(ForkJoinPool-1-worker-5, ForkJoinPool-1-worker-5, ForkJoinPool-1-worker-7, ForkJoinPool-1-worker-7, ForkJoinPool-1-worker-7, ForkJoinPool-1-worker-3, ForkJoinPool-1-worker-3, ForkJoinPool-1-worker-3, ForkJoinPool-1-worker-1, ForkJoinPool-1-worker-1, ForkJoinPool-1-worker-1)
         */
    }
}
