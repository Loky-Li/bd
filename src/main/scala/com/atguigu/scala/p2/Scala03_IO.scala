package com.atguigu.scala.p2

import scala.io.StdIn

object Scala03_IO {
    def main(args: Array[String]): Unit = {

//        键盘输入
        var str : String = StdIn.readLine()
        println("line = " + str)

        var age : Int = StdIn.readInt()
        println("age = " + age)

        println("Do you love me?")
        var message = StdIn.readLine()

        println(message)
    }
}
