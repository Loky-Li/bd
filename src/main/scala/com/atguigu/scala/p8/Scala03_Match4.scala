package com.atguigu.scala.p8

object Scala03_Match4 {

    //todo 模式匹配 - match - 匹配列表
    def main(args: Array[String]): Unit = {

        //Array数组的元素是存放的多个List集合，并依次将List集合赋值给list
        //请思考，如果要匹配 List(88) 这样的只含有一个元素的列表,并原值返回.应该怎么写
        for (list <- Array(
            List(0),
            List(1, 0),
            List(0, 0, 0),
            List(1, 0, 0),
            List(88))) {

            val result = list match {

                case List(0) => "0" //匹配List(0)
                case List(x, y) => x + "," + y //匹配有两个元素的List
                case List(0, _*) => "0 ..."
                case _ => "something else"
            }

            println(result)
        }
    }

}
