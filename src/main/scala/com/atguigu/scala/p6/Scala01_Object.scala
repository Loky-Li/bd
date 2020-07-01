package com.atguigu.scala.p6

object Scala01_Object {
    def main(args: Array[String]): Unit = {
        var user : User = new User()
        println(user.name)
        println(user.login())

    }
}

//声明类
class User{
    //声明属性（变量）
    var name : String = "雨宣"

    //声明方法
    def login():Boolean = {
        true
    }
}
