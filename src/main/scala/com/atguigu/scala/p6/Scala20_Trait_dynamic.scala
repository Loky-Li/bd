package com.atguigu.scala.p6


object Scala20_Trait {
    def main(args: Array[String]): Unit = {

        // Scala支持对象动态混入特质：
        // 创建对象时，可以动态添加功能。解决装饰者模式的缺点
        //格式如下：直接在对象后面 with + 新加特质
        var user = new User20() with Trait20
        user.insert()
        user.update()
    }
}

class User20{
    def insert(): Unit ={
        println("insert user data....")
    }
}

trait  Trait20{
    def update(): Unit ={
        println("update user data...")
    }
}













