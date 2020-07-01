package com.atguigu.scala.p7

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Scala04_Array_Transform {
    def main(args: Array[String]): Unit = {
        //todo 集合 - Array - 数组 - 转换 / 多维数组
        val array = Array(1,2,3)
        val buffer: ArrayBuffer[Int] = ArrayBuffer(1,2,3)

        //不可变 ——> 可变
        val buffer1: mutable.Buffer[Int] = array.toBuffer

        //可变 ——> 不可变
        val array1: Array[Int] = buffer.toArray

        //多维数组
        //下面的2维数组：元素为3个一维数组，一维数组的有4个Int类型的元素
        val arr: Array[Array[Int]] = Array.ofDim[Int](3,4)
        //给其中的一个元素赋值
        arr(1)(3) = 88
        //打印二维数组
        for(i <- arr){
            for(j <- i){
                print(j + " ")
            }
            println()
        }







    }

}
