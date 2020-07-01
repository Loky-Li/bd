package com.atguigu.scala.p11

object Scala02_Generic {
    def main(args: Array[String]): Unit = {
        //todo 泛型 - 上下限 -
        // 对应Java中的testGeneric2

        //测试方法上限
        test(new User())
//        test(new Parent())    //error
        test(new Child())

        //测试方法下限
        //todo - 方法的泛型没有下限的限制！！！！在编译后发现，限制下限并没有生效
        test1(new User())
        test1(new Parent())
        test1(new Child())

        //测试类的上限
        println(new Person[User]())
//        println(new Person[Parent]())     //error
        println(new Person[Child]())

        //测试类的下限
        println(new Person1[User]())
        println(new Person1[Parent]())
//        println(new Person1[Child]())     //error
    }

    //方法上限
    def test[T<:User](t:T): Unit ={
    }

    //方法下限（不生效）
    def test1[T>:User](t:T): Unit ={
    }
}

//类的上限
class Person[T<:User]{}

//类的下限
class Person1[T>:User]
