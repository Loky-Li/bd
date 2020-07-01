package com.atguigu.scala.Exer

object Scala_p8_01 {
    def main(args: Array[String]): Unit = {
        val a = 1
        val b = 3
        val op: Char = '-'

        val result: Any = op match {
            case '-' => a - b
            case _ => "test"
        }
        println(result)
    }

}
