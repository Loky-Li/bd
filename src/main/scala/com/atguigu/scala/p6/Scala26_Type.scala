package com.atguigu.scala.p6

object Scala26_Type{
    println("xxx")
    def main(args: Array[String]): Unit = {

        //使用Type来自定义类型
        type S=String
        var v:S="abc"
        def test():S="xyz"
    }
}
