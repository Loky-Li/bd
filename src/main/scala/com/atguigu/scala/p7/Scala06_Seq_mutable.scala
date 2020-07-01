package com.atguigu.scala.p7

import scala.collection.mutable.ListBuffer

object Scala06_Seq_mutable{
    def main(args: Array[String]): Unit = {
        // 集合 - Seq - List （可变）

        val buffer: ListBuffer[Int] = ListBuffer(1,2,3,4)


        buffer.append(5)
        buffer.insert(1,12)
        println(buffer)

        buffer.update(0,7)
        println(buffer)
        buffer(0) = 77      //这在不可变集合中是初始赋值，在可变集合中为update
        println(buffer)

        buffer.remove(0)
        println(buffer)
        buffer.remove(3,1)  //（索引，remove的个数）
        println(buffer)

        //遍历，使用简化的写法
        buffer.foreach(println)
        //遍历，模块String的写法
        println(buffer.mkString("|"))
    }
}
