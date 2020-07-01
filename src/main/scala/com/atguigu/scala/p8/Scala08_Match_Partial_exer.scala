package com.atguigu.scala.p8

object Scala08_Match_Partial_exer {
    def main(args: Array[String]): Unit = {

        //todo - 匹配 - 偏函数 - 深入理解偏函数 - 使用collect

        val list = List(1,2,3,4,5,6,"test",true)

        //需求：将该List(1,2,3,4,5,6,"test")中的Int类型的元素加一，并去掉字符串

        //todo 注意偏函数的格式，和函数的很不同！！！
        // 参数和返回值类型放在一个中括号内。
        // 自己练习：自定义和collect方法一样功能的偏函数 col。
        // -----------------------
        // 写着写着发现，自己根本写不出来，没有那么简单，看源码也很复杂
        // 想自己写的原因是开始以为，collect()只是实现偏函数的一种方法，存在使用场景的局限性。但后来发现
        // collect()方法就是Scala已经封装好的偏函数。并不存在使用局限性。直接拿来用即可，所以无需自己再写

        /*
        val col:PartialFunction[List[Int],Option[Int]] = {
            case
        }*/

        //todo 理解偏函数的原理：
        // 见文档： 偏函数 = filter 过滤 + map转换。
        // collect 就是 采集： 将满足条件的数据采集过来，然后处理返回

//        val list = List(1,2,3,4,5,6,"test",true)
        val ints: List[Int] = list.collect { //todo 注意是大括号
            case num: Int => num + 1
        }
        println(ints)

        // 上面的如果不使用collect的话,使用 filter 和 map会比较复杂
        val result: List[Int] = list
          .filter(_.isInstanceOf[Int])
          .map(_.asInstanceOf[Int])
          .map(_ + 1)

        println(result)

    }

}
