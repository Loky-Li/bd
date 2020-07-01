package com.atguigu.scala.test

object Function_test3 {

 def main(args: Array[String]): Unit = {

/*     def test()={

         for(i <- 1 to 5){
             if(i < 3){
                 "Xenai"
             }else{
                 520
             }
         }
     }*/

     var flg:Boolean = true

     var i = if(flg){
         new A()
     }else{
         "Xenia"
     }

     println(i)

    }
}

class A{

}