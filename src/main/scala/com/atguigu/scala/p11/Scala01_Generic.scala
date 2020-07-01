package com.atguigu.scala.p11

object Scala01_Generic {
    def main(args: Array[String]): Unit = {
        //todo 泛型
        // Java中的泛型见 testGrneric

        //Scala中的泛型和Java一样，默认也是不可变。
        //Scala中扩展支持泛型可变。 但在声明的时候，需要使用特殊的符号
        // T  => 泛型不可变
        // +T => 泛型的协变（子类型）
        // -T => 泛型的逆变（父类型）

        // todo 格式 +T => 泛型的协变。创建本类和它的子类
//        val test: Test[User] = new Test[Child]()      //对应于：class Test[+T]{}

        //如果一定要限制Scala泛型不被外界修改为可变：
        // todo 使用泛型的逆变。格式 -T =>泛型的协变。创建本类和它的父类
        val test: Test[User] = new Test[Parent]()  //对应于：class Test[-T]{}

        println(test)
    }
}

class Parent{}

class User extends Parent{}

class Child extends  User{}

//class Test[+T]{}
class Test[-T]{}
