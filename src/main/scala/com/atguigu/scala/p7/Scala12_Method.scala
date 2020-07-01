package com.atguigu.scala.p7

object Scala12_Method {
    def main(args: Array[String]): Unit = {

        //集合 - 常用方法
        val list = List(1,2,3,4)

        //println(list.length)
        //println(list.size)

        //组成部分
        // 5 :+ list 、 list +. 5
        println(list.head)      //第一个元素
        println(list.tail)      //除了head，即第一个元素的后段元素
        println(list.last)      //最后一个元素
        println(list.init)      //除了最后一个元素的前段元素
        //函数式编程最多的用法是递归：所以上面获取前段和后段的方法，在递归中使用

        //循环
        //list.iterator
        //list.productIterator
        list.foreach(println)       //----理解这个简化写法的完整格式：见Scala02

        //。。。

    }

}
