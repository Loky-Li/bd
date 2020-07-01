package com.atguigu.scala.p6

object Scala18_Trait{
    def main(args: Array[String]): Unit = {
        //todo 面向对象  - Trait

        //特质从原理上其实就是interface 和 抽象类的 集合体
        //所以当使用extends来混入特质时，其实采用的接口的实现implements

        val emp=new Emp18()
        emp.test1()


    }
}

class Parent18{

}
//如果一个类只有特质，没有父类，可以直接使用extends来混入特质

//如果一个类有父类，又要混入特质，使用使用with来混入特质
//todo： 方式一：class Emp18 extends Parent18 with MyTrait18 {

//todo：方式二：或者让特质继承该类的父类，然后该类再继承这个特质。Java中接口不可以继承类。
//在编译后，MyTrait18并没有真正继承了父类,最终编译器还是由Emp18自动地  既继承父类，又实现接口
class Emp18 extends MyTrait18 {
    def test(): Unit ={

    }

}

trait MyTrait18 extends Parent18 {
    //声明属性
    //在特质中声明属性，等同于声明属性的抽象get/set方法
    var num : Int = _

    //声明抽象方法（类似Java接口中的抽象方法）
    def test():Unit

    //声明完整的方法
    //在编译后发现，MyTrait18的实现类Emp18能直接调用特质中的方法test1()的原因是
    // Emp18会调用MyTrait18的一个特殊的类来完成方法的调用（类为：当前类名$class）（不是很理解）
    def test1(): Unit ={
        println("xxxxx")
    }
}