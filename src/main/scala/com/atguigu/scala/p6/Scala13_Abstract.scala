package com.atguigu.scala.p6

object Scala13_Abstract {
    def main(args: Array[String]): Unit = {
        //todo 面向对象  - 抽象类

        //抽象类的含义：不完整的类。抽象方法：不完整的方法。缺一些具体的东西
        //抽象方法一定在抽象类中，抽象类中可以有不是抽象的方法


        val user = new User13()
        user.test()


    }
}
abstract class Parent13(){

    //声明普通方法
    def  test(): Unit ={
        println("Parent13 test ...")
    }

    //声明抽象方法：只有声明，没有实现
    //只要方法声明不完整，那么就是抽象的方法，不需要使用abstract关键字
    def test1(): Unit
}

//子类继承抽象类，那么必须重写方法，或者子类自己声明为抽象类
//Scala中重写分为两种：
//①：抽象方法的重写：将父类的抽象方法补充完整，不需要修饰符
//②：完整方法的重写：为了明确方法是用于重写，所以需要增加修饰符 override（注意不是加注解！！！）
class User13() extends Parent13(){

    //Scala中属性和方法都是动态绑定，而Java中只有方法为动态绑定。
    override  def  test(): Unit ={
        println("User13 test ...")
    }

    //抽象方法补充完整（方法的重写）
    def test1(): Unit ={
        println("user13 test1....")
    }

}




