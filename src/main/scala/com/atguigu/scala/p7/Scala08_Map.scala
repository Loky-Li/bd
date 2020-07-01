package com.atguigu.scala.p7
import scala.collection.mutable

object Scala08_Map {

    def main(args: Array[String]): Unit = {

        // 集合 - Map （不可变）
        //Map集合保存 键值对
        //Scala中键值对 格式 ： K -> V
        val map: Map[String, Int] = Map("a" -> 1,"b" -> 2,"c" -> 3)

        // 集合 - Map （可变）
        val muMap: mutable.Map[String, Int] = mutable.Map("a" -> 1,"b" -> 2,"c" -> 3)
        println(muMap)

        muMap.put("d",4)
        println(muMap)

        //更新
        muMap.update("d",5)
        //更新：简写 (可变的集合都可以直接省略update)
        muMap.update("d",6)
        println(muMap)

        muMap.remove("d")
        println(muMap)

        println(muMap)
        println(muMap.foreach(println))
        println(muMap.mkString(","))

    }

}
