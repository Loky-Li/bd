package com.atguigu.scala.p6

object Scala22_Trait {
    def main(args: Array[String]): Unit = {

        var user = new User22()
    }
}

trait Trait22{
    println("trait22....")
}

trait  Trait222 extends  Trait22 {
    println("trait222.....")
}

trait  Trait2222 extends  Trait22 {
    println("trait2222.....")
}

class User22 extends Trait2222 with Trait222 {
    println("user22....")
}

//总结：..初始化后就无需再初始化
//trait22....
//trait2222.....
//trait222.....
//user22....












