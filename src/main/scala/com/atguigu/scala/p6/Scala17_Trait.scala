package com.atguigu.scala.p6

object Scala17_Trait{
    def main(args: Array[String]): Unit = {
        //todo 面向对象  - Trait
        //Scala中没有接口的概念，而又Trait特质，意为：
        //Scala中将多个类的相同特征从类中剥离出来，形成一个独立的结构，称之为“特质”

        //特质（特征）
        //如果一个类拥有某一个特征，那么将这个特征混入到类中
        //一个类可以混入多个特质

    }
}

//混入特质：extends
//混入特质时，需要使用extends关键字，如果混入多个特质，需要使用with。后面一直使用with xxx
class  User17 extends MyTrait with MyTrait1 {

}

class Emp17{

}

trait MyTrait1{

}