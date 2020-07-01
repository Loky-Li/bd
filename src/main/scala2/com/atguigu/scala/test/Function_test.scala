package com.atguigu.scala.test.xxxxx


object Function_test {

    def main(args: Array[String]): Unit = {



        def f9 = (x:String)=>{println("wusong")}

        def f10(f:String=>Unit) = {
            f("")
        }

        f9

        f10(f9)
        println(f10((x:String)=>{println("wusong")}))

    }

}
