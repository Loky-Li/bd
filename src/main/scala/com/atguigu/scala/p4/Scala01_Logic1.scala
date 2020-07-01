package com.atguigu.scala.p4

object Scala01_Logic1 {
    def main(args: Array[String]): Unit = {
        //Todo 逻辑控制
        var flag = true
        //下面的if省略了 { }，而第二句是在 if{ }之外的语句。
        if(flag)
            println("flag=true")
            println("flag=false")

        //判断下面i的类型，if的返回值，以最后的一行为准
        var i = if(flag){
            "LoveXenia"
            30
        }else{
//            "zhangsan"
            20.9
//            null
        }

        println(i)
    }

}
