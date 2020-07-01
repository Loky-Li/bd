package com.atguigu.scala.p7

import scala.collection.mutable

object Scala22_MapMerger {
    def main(args: Array[String]): Unit = {

        //集合 - 常用方法 - 按照指定规则进行计算

        //需求：将的两个map合并，有的话就sum value,没有的话，就put
        val map1: mutable.Map[String, Int] = mutable.Map(("a",1),("b",2),("c",3))
        val map2: mutable.Map[String, Int] = mutable.Map(("a",4),("d",5),("c",6))


        //使用Java来实现： 见 TestMapMerger（自己写）

        //使用foldLeft来实现： 将一个map作为外部初始元素，另一个map的键值对作为依次传入的参数
        //下面是以map1为外部元素，然后将map2中的键值对依次传入，所以使用map2来调用foldLeft()方法
        val result: mutable.Map[String, Int] = map2.foldLeft(map1)(
            (map, kv) => {
                //todo -->参数理解：
                // map的初始值是map1，之后是map1依次处理后得到的map
                // 而kv是map2中依次传入的键值对

                //将map2中的键值对取出，然后使用该键值对的key来在map中查，没有则为0，有则相加
                //map.getOrElse(kv._1,0) + kv._2
                //更新 map的value
                map(kv._1) = map.getOrElse(kv._1, 0) + kv._2
                //上面的map是可变集合，所以可以 update 使用简化的写法
                //完整是是 map.update(kv._1, map.getOrElse(kv._1, 0) + kv._2)

                //上面只是更新了map的value值，还需要返回整个map
                map
            }
        )
        println(result)

/*      //复习时自己的练习  2020-06-27
        val map3: mutable.Map[String, Int] = mutable.Map()

        for(tp <- map1){
            if(map2.get(tp._1).isEmpty){
                map3.put(tp._1, tp._2)
            }else{
                map3.put(tp._1, tp._2 + map2.get(tp._1).getOrElse(0))
            }
        }

        for (tp2 <- map2){
            if(map3.get(tp2._1).isEmpty){
                map3.put(tp2._1, tp2._2)
            }
        }

        map3.foreach(println)*/


        //复习练习使用折叠。
        //  由于是 map，tuple => map，所以想到使用foldLeft
        val res: mutable.Map[String, Int] = map1.foldLeft(map2)(
            (map, kv) => {
                map(kv._1) = map.getOrElse(kv._1, 0) + kv._2
                map
            }
        )



    }

}
