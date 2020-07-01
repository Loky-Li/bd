package com.atguigu.scala.p7

import scala.collection.mutable

object Scala17_WC_Exer_自写方式 {
    def main(args: Array[String]): Unit = {
        val tuples = List(
            ("Hello Hadoop Hive Kafka", 4),
            ("Hello Hadoop Hive", 3),
            ("Hello Hadoop ", 2),
            ("Hello", 1)
        )

          //todo 第一步的思路是抄老师的，将整个长String，转成单个单词
        //写到后面，我自己都不知道自己写什么了，但是就是对
        // 感觉自己好牛逼，写出这么复杂的逻辑，只有做的时候看得明白，写完后自己都看不懂

        //①：拿到一个tuple后，就先将字符串变成多个单词，再将单词 乘 个数
        val tp: List[(String, Int)] = tuples.flatMap(
            t => {
                //以tuple为参数，处理一个tuple，将tuple的第一个元素拆成由多个字符串组成的数组
                //从这个处理逻辑可以看到，函数出循环处理每一个元素
                val strings: mutable.ArrayOps[String] = t._1.split(" ")
                //处理后得到的strings数组中的每个元素再使用map处理
                // （同样是循环，感受一下这种逻辑。如果当成整体的话，思维容易乱）
                strings.map((_, t._2))
            }
        )
        println(tp)

        val stringToTuples: Map[String, List[(String, Int)]] = tp.groupBy(kv => {
            kv._1
        })
        println(stringToTuples)

        val stringToInts: Map[String, Int] = stringToTuples.map(kv => {
            (kv._1,kv._2.map(_._2).sum)
        })
        println(stringToInts)

        val list: List[(String, Int)] = stringToInts.toList
        println(list)

        val finalCountTail3: List[(String, Int)] = list.sortWith(
            (left, right) => {
                left._2 < right._2
            }
        ).takeRight(3)

        println(finalCountTail3)



    }

}
