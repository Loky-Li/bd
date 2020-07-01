package com.atguigu.scala.p6

object Scala21_Trait {
    def main(args: Array[String]): Unit = {

        //todo 特质是抽象类和接口的集合体，所以可以通过关键字来判断特质扮演的角色

        //todo 类在既继承了父类，又混入特质时，先考虑父类，后是特质
        // 执行的顺序是：
        // 优先初始化父类的相关内容
        // 然后初始化当前类的特质内容
        // 最后再初始化类的主体内容
        //..初始化过的就无需再初始化
        var user = new User21()
    }
}

trait Trait211{
    println("trait211....")
}

trait  Trait21 extends  Trait211 {
    println("trait21.....")
}

class Parent21 extends Trait211 {
    println("parent21....")

}

//有两个混入的时候，先看左边的
class User21 extends Parent21 with Trait21 {
    println("user21....")
}















