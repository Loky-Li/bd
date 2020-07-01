package com.atguigu.scala.p7

object Scala18_Method3 {
    def main(args: Array[String]): Unit = {

        //集合 - 常用方法 - 多元数据操作
        val list1 = List(1,2,3,4)
        val list2: List[Int] = List(4,5,6,7,8)
        val list3 = List(1,2,3,4,5,6,7,8)

        //todo 并集 union
        println(list1.union(list2))

        //todo 交集 intersect
        println(list1.intersect(list2))

        //todo 差集：谁在前保留谁 diff
        println(list1.diff(list2))
        println(list2.diff(list1))

        //todo 拉链：两两成对，索引相同的放在一起 zipa
        println(list1.zip(list2))  //list2中的8没有出现

        //todo 滑动窗口：sliding  多n个值放在一个集合中，并滑动
        //举例：Java中实现连续三个数值的求和
        val iterator: Iterator[List[Int]] = list3.sliding(3)
        while(iterator.hasNext){
            print(iterator.next().sum + ",")
        }
        println()
        //翻滚滑动： 窗口大小 = step 时，没有重复
        val iterator2: Iterator[List[Int]] = list3.sliding(3, 3)
        while(iterator2.hasNext){
            println(iterator2.next().sum + ",")
        }



    }

}
