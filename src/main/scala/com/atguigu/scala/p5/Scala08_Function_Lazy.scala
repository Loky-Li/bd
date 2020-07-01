package com.atguigu.scala.p5

object Scala08_Function_Lazy {

    def main(args: Array[String]): Unit = {

        //todo  函数式编程 - 延迟加载

        lazy val res = sum(1,2)   // ①
        println("--------------")   // ②
        println("res :" + res  )    // ③

        //todo 作用总结：
        /*
        当②的代码的执行如果需要消耗大量的时间，而①中的代码产生的数据量又很大时，
        ①中的大量数据将会临时存储在内存中，等待②执行完毕，这将在内存中占用大量的空间
        使用了惰性函数，延迟加载之后，只有②执行完毕之后，执行到③，发现用到res变量
        此时返回去执行被 lazy 标志的 ①
         */


    }

    def sum(i: Int , j: Int ): Int = {
        println("SUM函数正在被执行------")
        return  i + j
    }

}
