package com.atguigu.scala.p7

object Scala20_Method5 {
    def main(args: Array[String]): Unit = {

        //集合 - 常用方法 - 按照指定规则进行计算
        val list = List(1,2,3,4)

        //需求：List(1,2,3,4) 从 (Int,Int) => String(1234)
        //todo 折叠，...
        //def fold[A1 >: A](z: A1)(op: (A1, A1) => A1): A1 = foldLeft(z)(op)
        //理解(z: A1)，当参数是z时，表示zero，表示初始值
//        list.fold(_+_)
        //但是 fold的参数类型，同样的传入参数和返回值的类型要一致。

        //为了解决需求中要求类型不同的问题，可以使用foldLeft()
        list.foldLeft("")(_+_)

        //todo 小结：相同类型的折叠就使用 fold，不同类型的折叠使用foldLeft()

        //同样的foldRight()和reduceRight()一样依赖于xxxLeft()
        list.foldRight("")(_+_)

        //todo 特别，理解下面的初始值是在哪里，及给出完整的运算过程

        //无论foldLeft还是foldRight，外部插入的值都是放在第一位。而
        // foldLeft不改变需要折叠的list，foldRight将需要折叠处理的集合反转
        //所以foldRight处理的整体为 外部+ 反转的list： 0,5,4,3,2,1

        //使用简化记忆版,就不用管外部元素的实际位置，初始值位置left的在左，right的在右，再依次嵌套括号：
        list.foldLeft(0)(_-_)   // (((((0 - 1) - 2) - 3) - 4) - 5)
        list.foldRight(0)(_-_)  //（1 - （2 - (3 - (4 - （5 - 0）)))

        //可以通过scanLeft 和scanRight来验证计算的中间值： 见方法Scala21方法




    }

}
