package com.atguigu.scala.p7

import java.util

object Scala17_WC_Exer_2 {
    def main(args: Array[String]): Unit = {
        val list = List(
            ("Hello Hadoop Hive Kafka", 4),
            ("Hello Hadoop Hive", 3),
            ("Hello Hadoop", 2),
            ("Hello", 1)
        )

//        k-v中k为单词的字符串，v为这个串的数量
//        需求：统计单词出现次数排名前3的单词


//        todo 方法一：字符串重复出现
        println(list.map(tp => (tp._1 + " ") * tp._2))
//        之后就是上一个案例的单纯统计单词了


//        todo 方法二 ：使用转换
        // ("Hello Hadoop Hive Kafka", 4)
        // hello =>(hello, 4)
        // hadoop =>List((hadoop, 4), (hadoop, 3), (hadoop, 2),(hadoop, 1))
        // hadoop =>List((4), (3), (2),(1))
        // (hadoop, 10)
        // (hive, 4)
        // (kafka, 4)

        val wordToCountList: List[(String, Int)] = list.flatMap(
            t => {
                val words = t._1.split(" ")
                words.map((_, t._2))
            }
        )
        println(wordToCountList)

        val wordToCountsMap: Map[String, List[(String, Int)]] = wordToCountList.groupBy(_._1)
        println(wordToCountsMap)

        //        val wordToSumMap: Map[String, Int] = wordToCountsMap.map(
        //            t => {
        //                val ints: List[Int] = t._2.map(_._2)
        //                (t._1, ints.sum)
        //            }
        //        )

        //todo 上面注释的部分可以使用  mapValues，
        // mapValues的作用是对 value进行操作，而不会改变key
        //如下：ordToCountsMapd的key为String，value为List(对偶元组)，
        // 那么传入mapValue的value就是List(对偶元组)，使用map将对偶数组的 单词数留下，
        // map后的结果就是一个数值的List集合，可以使用sum的方法对List内的值求和
        val wordToSumMap: Map[String, Int] = wordToCountsMap.mapValues(
            list => {
                list.map(_._2).sum
            }
        )

        println(wordToSumMap)

/*
//        复习时重写
        val wordAndCountList: List[(String, Int)] = list.flatMap(tuple => tuple._1.split(" ").map((_, tuple._2)))

        val wordAndSum: Map[String, Int] = wordAndCountList
          .groupBy(tp => tp._1)
          .map(tuple => (tuple._1, tuple._2.map(_._2).sum))

        println(wordAndSum)*/
    }

}
