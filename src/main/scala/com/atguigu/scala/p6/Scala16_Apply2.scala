package com.atguigu.scala.p6

object Scala16_Apply2 {

    def main(args: Array[String]): Unit = {

        val user = new User166()
        val user1 = User166.apply()
        val user2 = User166()
        val user3 = User166( "Lisi" )

        println("---------------打印----------------")
        println(user)
        println(user1)
        println(user2)
        println(user3)
    }
}
class User166(name: String="zhangsan"){
    println(name)
}
//class User166(){    }

object User166{
    def apply(): User166 = new User166()

    def apply(name: String = "zhangsan"): User166 = new User166(name)
}

