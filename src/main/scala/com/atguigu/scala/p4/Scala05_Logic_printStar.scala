package com.atguigu.scala.p4

import scala.util.control.Breaks

object Scala05_Logic_printStar {
    def main(args: Array[String]): Unit = {
       //Todo 逻辑 - 循环 - 多重循环

        //实现一个for循环打印九层妖塔。 知识点： Scala中的字符串也可以运算
        for(i <- new Range(1,18,2); j = (18 -i) /2){

            println(" " *j + "*"*i + " " * j)
        }

        println("------使用 to 的方式实现，原理差不多-----------")
        for(i <- 1 to 9;j=(9-i)){
            println( " "* j + "*" * (2*i -1) + " " * j)
        }
    }
}
