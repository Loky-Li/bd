package com.atguigu.scala.p7

import scala.collection.mutable

object Scala07_Set {

    def main(args: Array[String]): Unit = {

        // 集合 - set （不可变）
        //Set : 无序不可重复
        // 无序：是和插入顺序相关，不是数值的大小
        //不可重复：Java中hashSet的底层是HashMap，而key不可能重复。Scala也是如此
        val set: Set[Int] = Set(1,2,3,4,5,6,6,6)
        println(set)
        //无序，不可重复   Set(5, 1, 6, 2, 3, 4)

        // 集合 - set （可变）
        val muSet: mutable.Set[Int] = mutable.Set(1,2,3,4)

        muSet.add(5)
        println(muSet)

        //update可以添加数据，也可以删除数据
        //由于Set无序，没有索引，所以传入的参数是元素 elem。
        muSet.update(2,true)        //没有变化
        println(muSet)
        muSet.update(2,false)      //false,便是更新这个集合，并且不包含 2，则原来是否存在2，2都将不存在
        println(muSet)

        muSet.update(6,false)       //false,便是更新这个集合，并且不包含6
        println(muSet)
        muSet.update(6,true)
        println(muSet)
        //todo 总结 理解update(值,boolean)：表示更新集合，使得几种中包含/或不包含 传入的 值

        //删除：同样的Set没有索引，所以传入的参数也是一个集合元素
        muSet.remove(6)  //表示删除元素6


        //遍历：一样的三种方式
        println(muSet)
        println(muSet.foreach(println))
        println(muSet.mkString(","))



    }

}
