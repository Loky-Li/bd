package com.atguigu.scala.p6

object Scala14_Abstract3 {
    def main(args: Array[String]): Unit = {

        //创建匿名子类
        var user:User143 = new User143 {
            override var name: String = "loky"

            override def test(): Unit = {
                println("test")
            }
        }

        //匿名子类的调用
        println(user.name)
        user.test()

    }
}

abstract class User143{
    var name:String
    def test():Unit
}



