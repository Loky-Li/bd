package com.atguigu.scala.p6

object Scala14_Abstract2 {
    def main(args: Array[String]): Unit = {

        val user1:User144 = new User144
        println(user1.age)
        user1.say()

        //下面的对象也还是User，由于成员方法和属性都遵循动态绑定，所以结果和上面一样
        val user2:Person144 = new User144
        println(user2.age)
        user2.say()


    }
}

abstract class Person144{
    val age:Int = 18
    def say()={
        println("Person say")
    }
}

class User144 extends Person144{
    override val age: Int = 19

    override def say(): Unit = {
        println("User say")
    }
}



