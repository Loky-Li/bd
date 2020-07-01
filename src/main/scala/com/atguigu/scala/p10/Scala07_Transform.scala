package com.atguigu.scala.p10

import com.atguigu.scala.p10.Scala07_Transform.Teacher
//todo - 隐式类 - 隐式解析机制
// （1）首先会在当前代码作用域下查找隐式实体（隐式方法、隐式类、隐式对象）。（一般是这种情况）
// （2）如果第一条规则查找隐式实体失败，会继续在隐式参数的类型的作用域里查找。
//      类型的作用域是指与该类型相关联的全部伴生对象以及该类型所在包的包对象。


//todo 规则②：如果第一条规则查找隐式实体失败，会继续在隐式参数的类型的作用域里查找。
// 类型的作用域是指与该类型相关联的全部伴生模块，
object Scala07_Transform extends  PersonTrait {
    def main(args: Array[String]): Unit = {


        // todo 规则①：首先会在当前代码作用域下查找隐式实体
        val teacher = new Teacher()
        teacher.eat()
        teacher.say()

    }

    class Teacher{
        def eat(): Unit ={
            println("eat...")
        }
    }
}

trait PersonTrait{}

object PersonTrait{
    implicit class Person5(user:Teacher){
        def say(): Unit ={
            println("say...")
        }
    }
}

