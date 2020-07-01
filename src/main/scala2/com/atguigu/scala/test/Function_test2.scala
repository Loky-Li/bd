package com.atguigu.scala.test

object Function_test2 {

 def main(args: Array[String]): Unit = {

     /*   def test1(f:() => Unit): Unit ={
         println("start")
         f
         println("end")
     }

     test1{
         println("hello")
         println("Xenia")
         ()=>{println("bb")}
     }*/

    def test1(code:()=>Unit){
     println("start")
     code() // 要想调用传入的代码块，必须写成code()，否则不会调用。
     println("end")
    }
    test1 {//此代码块，传入后立即执行。
        println("when evaluated")
        ()=>{println("bb")}
        println("when evaluated 2")

    }


    }

}
