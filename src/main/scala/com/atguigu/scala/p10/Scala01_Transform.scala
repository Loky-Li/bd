package com.atguigu.scala.p10

object Scala01_Transform {
    def main(args: Array[String]): Unit = {
//        val d:Int = 2.0
//        println(d)

        //下面不会报错，红线只是IDEA本身的原因
        // 因为编译器是先对右边的算术自动计算，如果结果在Char范围内，不会报错。
        // 类似于 val i: Int = 1+1+1. 实际上JVM不会一步步加，而是编译器直接将1+1+1编译为3
        val c:Char = 'A'+1
        println(c)

        //todo 隐式转换的功能引入
        //在版本升级的过程中，保证不和程序有耦合性。要保证不修改代码
        // 解决方式新增一个重载方法，并调用一个

        //Scala中提供了小到大的自动类型转换
        //但是没有提供从大到小的转换：

        //todo Scala声明下面的方法，用于编译器的自动转换。
        // 为了让编译器识别，在函数前加上关键字   implicit
        // 隐式转换是在编译程序时发生错误后，会尝试通过隐式转换将数据类型发生变化，再尝试执行看是否能执行。
        // 所以也称为2次转换。
        implicit def transform(d:Double):Int ={
            d.toInt
        }

        //声明了隐式转换之后，下面的代码不会报错
        val d:Int = 2.0
        println(d)
    }

}
