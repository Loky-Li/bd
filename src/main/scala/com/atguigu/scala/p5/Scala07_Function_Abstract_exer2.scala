package com.atguigu.scala.p5

import scala.util.control.Breaks._

object Scala07_Function_Abstract_exer2 {

    def main(args: Array[String]): Unit = {

        //todo  函数式编程 - 控制抽象
        // 手写whileY  （2020-06-22复习）
        def whileY(bool: => Boolean)(op: => Unit): Unit ={
            if(bool){
                op
                whileY(bool)(op)
            }else{
                print("结束循环")
            }
        }
    }

}
