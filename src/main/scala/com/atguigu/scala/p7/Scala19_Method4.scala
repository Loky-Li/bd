package com.atguigu.scala.p7

object Scala19_Method4 {
    def main(args: Array[String]): Unit = {

        //集合 - 常用方法 - 按照指定规则进行计算
        val list = List(1,2,3,4,5)


        //todo 简化，规约，聚合
        //采用自定义计算规则对集合数据进行聚合操作
        val i: Int = list.reduce((x,y) => x+y)
        //reduce的返回值必须和传入的参数类型是一致的，所以存在局限性

        //为了实现 (Int,Int) => String(1234)，由于返回值类型是String，所以不能使用reduce

        //从左边开始聚合：reduceLeft()
        println(list.reduceLeft(_ + _))


        //但是reduceLeft(f:(B,Int)=>B),虽然第一个参数和返回值类型为B，不指定，即两个参数类型可以不一样
        // 但是在源码中，reduceLeft[B >: A]...中的[B >: A]表示B和A的类型有关联，
        // 而Int和String没有关联，所以reduceLeft也不能使用

        println(list.reduceRight(_ - _))

        //从源码中理解 list.reduceRight()的计算过程  (点reduce进去看，直接点reduceRight不行)
        //reversed.reduceLeft[B]((x, y) => op(y, x))：
        //--①：先对要规约聚合的集合反转
        //--②：使用reduceLeft来计算，而规约的两个值再对调位置

        //todo 简化记忆：按顺序及运算符写，然后按左右依次嵌套加括号。如：
        //reduceLeft(_-_) ： ((((1 - 2) - 3)- 4) - 5)
        //reduceRight(_-_)：(1 - (2 - (3 - (4 - 5))))


    }

}
