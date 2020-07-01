package com.atguigu.scala.test

object Function_test4 {
    def main(args: Array[String]): Unit = {

        val test = new test4()
        val test2 = new test4(3)
    }

}

class test4(){
    println("test4 main constructor")

    def this(id:Int){
        this()
        println("back up constructor")
    }
}
