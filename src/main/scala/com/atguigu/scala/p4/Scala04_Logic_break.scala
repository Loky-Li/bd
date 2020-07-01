package com.atguigu.scala.p4

import scala.util.control.Breaks

object Scala04_Logic_break {
    def main(args: Array[String]): Unit = {
       //Todo 逻辑 - 循环 - break

        //Scala中使用一个面向对象的方式来实现break的语法
        Breaks.breakable(
            for(i <- 1 to 10){
                println(i)
                if(i == 5)
                    Breaks.break()
            }
        )

        println("循环结束")


    }
}
