package com.atguigu.scala.p2

object Scala11_DataType3 {

    def main(args: Array[String]): Unit = {
        //todo  在 Scala中，数据类型也是对象，所以没有Java中的强制转换， 使用的是 toXXXX来转换
        var d :  Double = 0.9

        var i : Int = 1

        d=i.toDouble

        println(d)

        var r : Int = (1.3 + 3.5 + 1* 3.2).toInt

        println(r)


    }

}
