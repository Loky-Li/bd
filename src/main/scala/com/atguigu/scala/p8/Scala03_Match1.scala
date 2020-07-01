package com.atguigu.scala.p8

object Scala03_Match1 {


    def main(args: Array[String]): Unit = {
        //todo 模式匹配 - match - 匹配常量

            println(describe(6))

    }

    def describe(x: Any) = x match {

        case 5 => "Int five"

        case "hello" => "String hello"

        case true => "Boolean true"

        case '+' => "Char +"

        case _ => "xxxxx"

    }




}
