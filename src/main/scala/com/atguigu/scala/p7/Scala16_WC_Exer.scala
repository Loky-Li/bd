package com.atguigu.scala.p7

object Scala16_WC_Exer {
    def main(args: Array[String]): Unit = {
        val tuples = List(
            ("Hello Hadoop Hive Kafka", 4),
            ("Hello Hadoop Hive", 3),
            ("Hello Hadoop ", 2),
            ("Hello", 1)
        )

        //①：先将字符串的所有个数求出
        val strList: List[String] = tuples.map(tp => (tp._1 + " ") * tp._2)
        println(strList)

        //②：将字符串集合中的每个单词扁平
        val strings: List[String] = strList.flatMap(s => s.split(" "))
        println(strings)

        //③：按照单词就行分组
        val strToGro: Map[String, List[String]] = strings.groupBy(s => s)
        println(strToGro)

        //④：统计每个单词对应的单词集合的长度（即单词的个数）
        val strToCount: Map[String, Int] = strToGro.map(kv => {
            (kv._1, kv._2.length)
        })
        println(strToCount)

        //⑤：过滤掉 " " 字符串
        val strFilter: Map[String, Int] = strToCount.filter(kv => {
//            kv._1 != ""       //这个可以过滤，但是一般使用下面的方式过滤
            !"".equals(kv._1)
        })
        println(strFilter)

        //⑥：对统计单词个数的map集合按单词数降序排序，并取出前三
        println(strFilter.toList.sortWith((left,right) => {
            left._2 > right._2
        }).take(3))
    }

}
