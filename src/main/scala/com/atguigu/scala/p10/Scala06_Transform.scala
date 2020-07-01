package com.atguigu.scala.p10

object Scala06_Transform {
    def main(args: Array[String]): Unit = {

        //todo - 隐式类
        // Scala可以使用隐式类来扩展功能
        // 在类的声明前增加implicit关键字，这个类就是隐式类，可以自动完成隐式转换
        // A类 => B类
        // 隐式类必须有主构造函数，且必须只有一个参数，参数为需要被转换的类。

        val user = new User()
        user.insertUser()
        user.updateUser()

        //运行的原理是：当user调用update方法时，发现类没有该方法，
        // 然后编译器找是否有隐式类对该类做转换，再查找该隐式类中是否有update方法

    }

    class User{
        def insertUser(): Unit ={
            println("insert user...")
        }
    }

    //定义隐式类
    implicit class ExUser(user:User){
        def updateUser(): Unit ={
            println("update user...")
        }
    }

}
