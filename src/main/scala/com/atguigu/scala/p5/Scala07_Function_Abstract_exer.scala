package com.atguigu.scala.p5

import scala.util.control.Breaks._

object Scala07_Function_Abstract_exer {

    def main(args: Array[String]): Unit = {

        //todo  函数式编程 - 控制抽象
        //通过查看Breaks的源码知道，Scala就是使用控制抽象及异常来模拟实现Java中的break

/*        Breaks.breakable{
            for(i <- 1 to 7){
                if(i > 4){
                    println("退出循化")
                    Breaks.break()

                }else{
                    println(i)
                }
            }
        }*/

        //类似Java中的静态输入后，简化上面的代码
        breakable{      //breakable是一个方法 Breaks.breakable，而{ } 内的则是方法的参数，多行用大括号
            for(i <- 1 to 7){
                if(i > 4){
                    println("退出循化")
                    break               //Breaks.break() 中小括号无参数，所以也可以省略
                }else{
                    println(i)
                }
            }
        }
    }

}
