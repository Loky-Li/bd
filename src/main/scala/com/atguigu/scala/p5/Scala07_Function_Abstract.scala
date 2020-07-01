package com.atguigu.scala.p5

object Scala07_Function_Abstract {

    def main(args: Array[String]): Unit = {

        //todo  函数式编程 - 控制抽象

        //将代码作为参数传递
        //op: => Unit 的解析： 这是将函数作为参数传入到test。
        // 其中前面部分函数名为op。后面部分为op的类型，即 它的类型为方法 ()=>Unit
        // 没有参数还省略了(),返回值类型为Unti

        def test(op: => Unit): Unit ={
            op
        }

        test(
            println("xxxx")  // 这部分就是 op，也就是作为一个函数整体传入到test的参数中
        )

        //函数柯里化的第二种写法：简化版，直接在声明时候就写
        //模仿写 while 循环
/*        def whilex(b: => Boolean)(op: => Unit): Unit ={
            if(b){
                op
                whilex(b)(op)
            }else{

            }
        }

        whilex(1>0)(
            println("xxxx")
        )*/


        //第二次练习
        //将判断条件和循环体分别拆分成两部分代码，并作为参数，使用控制抽象来完成
        def whilex(b: => Boolean)(op : => Unit) : Unit={
            if(b){
                op
                //递归实现循环
                whilex(b)(op)
            }else{
                println("循环结束")
            }
        }

        var i = 1;

        whilex(i < 10){
            println("打印：" + i);
            i = i + 1
        }







    }

}
