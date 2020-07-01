package com.atguigu.scala.p8

object Scala03_Match4_2 {

    //todo 模式匹配 - match - 匹配列表 - 方式二

    def main(args: Array[String]): Unit = {

        val list: List[Int] = List(1, 2, 5, 6, 7)

        list match {
            //类似：List(x,y,_*)
            case first :: second :: rest => println(first + "-" + second + "-" + rest)
            case _ => println("something else")
        }
    }


}
