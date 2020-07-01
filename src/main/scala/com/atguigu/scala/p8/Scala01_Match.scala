package com.atguigu.scala.p8

object Scala01_Match {

    //todo 模式匹配 - match - 概述
    // Scala中模式匹配为了代替java中的switch语法
    // 而且scala提供了更多的功能

    def main(args: Array[String]): Unit = {

        var a: Int = 10
        var b: Int = 20
        var operator: Char = 'd'

        //result的类型为Any
        //Scala中不需要使用break来跳出，当走完逻辑后，自动推测

        //Java中的default可以没有，但是Scala的匹配条件必须满足所有要匹配的元素，所以有时case _不能省略
        // Scala中的模式匹配如果没有任何一个条件满足，那么会发生错误MatchError
        //同时Java中的default可以的位置可以任意，最后如果没有case匹配到，default会执行。
        //但是在Scala中，会按照case的顺序依次匹配，只要满足就会执行相应逻辑，所以case _ 只能放在最后
        var result = operator match {
            case '+' => {
                a + b
            }       //这是完整的写法
            case '-' => a - b
            case '*' => a * b
            case '/' => a / b

            case _ => "illegal"
        }

        println(result)

    }

}
