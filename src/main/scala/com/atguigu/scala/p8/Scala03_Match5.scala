package com.atguigu.scala.p8

object Scala03_Match5 {

    //todo 模式匹配 - match - 匹配元组
    def main(args: Array[String]): Unit = {

       for(tuple <- Array(
           (0,1),
           (1,0),
           (1,1),
           (1,0,2))){

           val result = tuple match {
               case (0,_) => "0 ..."
               case (y,0) => "" + y + "0"
               case (a,b) => "" + a + " " + b
               case _ => "someThing else"
           }

           println(result)
       }

    }

}
