package com.atguigu.scala.p7

import scala.collection.mutable

object Scala09_Map1 {

    def main(args: Array[String]): Unit = {
        //todo： Map
        val wordToCount: mutable.Map[String, Int] = mutable.Map("a" ->1,"b"->2,"c"->3)

        //获取指定key的值value
        //java从Map中取一个不存在的key，返回为nul
        //Scala取一个不存在的key，返回None，无法获取value，使用get报错
        //Scala取一个存在的key，返回Some，可以调用get方法获取value
        //Scala中从Map中获取数据的结果为Option(选项)，只有两个值，一个是Some，一个是None
        val value: Option[Int] = wordToCount.get("b")       //------ ①
        val value1: Option[Int] = wordToCount.get("d")      //

        //将Option(选项)中的值取出来
        println(value)      //Some(2)
        println(value1)     //None

        //为了避免使用get，取到None时造成程序报错
        println(value.getOrElse(0))             //-------②
        println(value1.getOrElse(0))

        //----将 ① 和 ② 两步结合成一步
        println(wordToCount.getOrElse("b","哈哈，没有这个值"))      //2
        println(wordToCount.getOrElse("d","哈哈，没有这个值"))      //哈哈，没有这个值

        //Scala提供一个Option(选项)就是为了解决Java在取没有的值返回Null时，再使用时出现空指针异常
        //深入理解Java中的空指针异常： 见Java包中的代码 TestNull

        //迭代器,获取Key 或 Value  或 键值对
        val keys: Iterable[String] = wordToCount.keys
        for(i <- keys){
            println(i)
        }
        
        val values: Iterable[Int] = wordToCount.values
        for(j <- values){
            println(j)
        }

        val nodes: Iterator[(String, Int)] = wordToCount.iterator
        for(n <- nodes){
            println(n)
        }





    }

}
