package com.atguigu.scala.p2

object Scala01_Var {
    def main(args: Array[String]): Unit = {
        println("hello")

//      scala中声明变量可以采用val声明，不让变量的值发生变化
//      scala语言认为类型没有那么重要，可以通过编译器自动推断出来。
        val i = 10 + 10 + 10   // java虚拟机不会一个个加，而是直接先计算得到30，后赋值给i
      val ii = 30

      // 本地变量必须初始化
/*      var s:String
      s = "feifa"*/
      var s:String = "fejif"


    }
}
