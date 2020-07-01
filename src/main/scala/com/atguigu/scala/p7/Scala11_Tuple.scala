package com.atguigu.scala.p7

import scala.collection.mutable

object Scala11_Tuple {
    def main(args: Array[String]): Unit = {

        //todo 对偶元组： 如果元组中元素的数量只有2个,那么将这样的元组称之为 对偶 元组
        //也称之为 键值对
        val tuple: (String, Int) = ("雨宣",25)

        //Map中的键值对其实也是一个tuple
        val tuple1: (String, Int) = "b" -> 2

        //所以创建Map并添加元素时，还可以使用对偶元组的方式添加！
        val muMap: mutable.Map[String, Int] = mutable.Map(("a",1),("b",1))

        //那么获取Map中元素的key和value，其实就是打印一个对偶元组的第一、第二个元素
        for(kv <- muMap){
            print("Key: " + kv._1)
            println("   Value: " + kv._2)
        }
    }

}


