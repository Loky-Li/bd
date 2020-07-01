package com.atguigu.scala.p7

object Scala21_Method6 {
    def main(args: Array[String]): Unit = {

        //集合 - 常用方法 - 按照指定规则进行计算
        val list = List(1,2,3,4,5)


        //todo 扫描 scan：
        // 和fold的区别是：将fold方法中间的计算过程结果保留下面，形成集合
        //
        println(list.scan(0)(_ + _))

        println(list.scanLeft(0)(_ - _))

        println(list.scanRight(0)(_ - _))



    }

}
