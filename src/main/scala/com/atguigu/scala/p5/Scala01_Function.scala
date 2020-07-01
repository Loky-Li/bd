package com.atguigu.scala.p5

object Scala01_Function {

    def main(args: Array[String]): Unit = {
        //todo 函数式编程
        //Scala是一个多范式的语言：所以Scala也是一个完全面向函数编程的语言

        //def 函数名(参数列表):函数返回值类型 = {函数体}

        //函数 & 方法
        //类中的函数是方法，如main方法。没有放在类里面的函数就是函数
        //Scala中的语法非常灵活，可以在任意的语法结构中嵌套其他语法结构! 如类里面可以有类，方法里面可以有方法
        //函数（方法）中可以声明函数：下面的test()就是嵌套在main()方法里面的函数

        def test(): Unit = {
            println("xxx")
        }

        //注意函数不可以重载重写，否则报错。 方法则有
/*
        def test(): Unit ={
            println("ccc" +
              "ddd")
        }
*/

        //调用函数
        //函数名（参数）
        test()
        test2()

        //（2）Scala中函数可以嵌套定义
        def test2(): Unit ={

            def test3(name:String):Unit={
                println("函数可以嵌套定义")
            }
        }

        //那怎么调用test2()呢？下面的调用好像并没有起作用
        test2()




    }

}
