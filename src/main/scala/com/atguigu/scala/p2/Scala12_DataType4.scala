package com.atguigu.scala.p2

object Scala12_DataType4 {

    def main(args: Array[String]): Unit = {

        //基本类型转成String类型
        var str1 = 2 + ""
        var str2 : String = 3.5 + ""

        //String类型转成基本数值类型：
//todo String必须是有效的值才可以转成数值类型。如下面两种情况都会报错
//        var str = "hello"
//        var n1: Int = str.toInt
//        println(n1)

        //todo 下面这中情况超级容易错。
//        var str3 = "12.5"
//        var n2 : Int = str3.toInt
    }

}
