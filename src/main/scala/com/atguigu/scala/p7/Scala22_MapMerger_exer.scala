package com.atguigu.scala.p7

import scala.collection.mutable

object Scala22_MapMerger_exer {
    def main(args: Array[String]): Unit = {

        //集合 - 常用方法 - 按照指定规则进行计算

        //需求：将的两个map合并，有的话就sum value,没有的话，就put
        val map1: mutable.Map[String, Int] = mutable.Map(("a",1),("b",2),("c",3))
        val map2: mutable.Map[String, Int] = mutable.Map(("a",4),("d",5),("c",6))

        map2.foldLeft(map1)((map,kv) => {
            map(kv._1) = map.getOrElse(kv._1,0) + kv._2
            map
        }
        )

    }

}
