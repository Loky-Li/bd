package com.atguigu.scala.p7

import scala.collection.mutable.ArrayBuffer

object Scala03_Array_mutable {
    def main(args: Array[String]): Unit = {
        //todo 集合 - Array - 数组（可变）
        //在可变集合的普通操作方法一般都不会产生新的集合，但是运算符号方法一般都会产生新的集合
        //常用可变的原因： 不可变的操作符太多，容易忘记。同时可变的使用场景更加灵活

        val buffer = new ArrayBuffer[String]()

        //增加
        buffer.append("Xenia","Love","Loky")
        buffer.insert(1,"very")   //第一个参数是插入的索引位置。第二个参数是插入的内容,为可变参数，可以传入多个

        // 可表集合调用方法的时候，一般不会产生新的集合。但是使用运算符的时候，一般都是产生新的集合
        val strings: ArrayBuffer[String] = buffer.+:("dd")

        //todo += 不会产生新的数组。功能等同于 insert 。 这个在后面会经常用。
        //下面的 “+=” 用法可以用于 ： 方法链！（类似Java中的语法糖）
        buffer += "en"




        //修改：编译后下面两种修改的方式，在底层都一样
        buffer(0) = "雨宣"            //todo 注意：在可变集合中这是修改，在不可变集合中是赋值
        buffer.update(3,"敦宏")  //第一个参数是索引

        //删除
        //buffer.remove(1,3)  // todo 从索引1开始remove3个值
        //buffer.remove(2,1)

        //使用drop会产生一个新的数组。参数从左删除 1 个
        val buffer1: ArrayBuffer[String] = buffer.drop(1)
        //从右删除2个
        val buffer2: ArrayBuffer[String] = buffer.dropRight(2)

        //使用操作符，会产生新的数组
        val buffer3: ArrayBuffer[String] = buffer.-("en")

        println(buffer)
        println(buffer1)
        println(buffer2)
        println(buffer3)
    }

}
