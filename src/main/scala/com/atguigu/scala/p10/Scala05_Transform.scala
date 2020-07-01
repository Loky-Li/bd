package com.atguigu.scala.p10

object Scala05_Transform {
    def main(args: Array[String]): Unit = {

        //todo - 隐式类 - 前面的案例引入
        //同样使用前面的用户需要新加update功能时，可以新建类，然后声明隐式方法。
        //但是这样的做法还是有些繁琐。Scala引入了隐式类的方式来实现。见Scala06

        implicit def transform(user:User):ExUser = {
            new ExUser()
        }


        val user = new User()
        user.insertUser()
        user.updateUser()

    }

    class User{
        def insertUser(): Unit ={
            println("insert user...")
        }
    }

   class ExUser{
        def updateUser(): Unit ={
            println("update user...")
        }
    }

}
