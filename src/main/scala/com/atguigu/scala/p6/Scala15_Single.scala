package com.atguigu.scala.p6

object Scala15_Single {
    def main(args: Array[String]): Unit = {

        //todo 面向对象  - 构造方法  - 伴生对象：单例
        val user1: User15.type = User15

        println(user1)      //User15.type 类型，打印后发现是一个 User15$ 的伴生对象
    }
}

// 伴生对象
// 单例对象
//下面的伴生对象会生成两个类文件，其都可以在Java中被调用。
object User15{

}

