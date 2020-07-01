package com.atguigu.scala.p7

object Scala13_Method1 {
    def main(args: Array[String]): Unit = {

        //集合 - 常用方法
        val list = List(1,2,3,4)

        //功能
/*        println(list.sum)
        println(list.max)
        println(list.min)
        println(list.product) //todo 乘积 1x2x3x4
        */

        //功能 - 简单
        println(list.contains("2"))   //todo 是否包含指定元素-Boolean，不仅内容、还有类型

        println(list.reverse)        //todo 反转

        println(list.take(2))     //todo    -从左取2个元素

        println(list.takeRight(3))   // todo    -从右取3个元素

        println(list.distinct )      //todo 去重

        //按条件采集数据
        println(list.collect{
            case i if i%2== 0 => i*i
        })

    }

}
