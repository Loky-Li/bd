package com.atguigu.scala.p5

object Scala03_Function_Nightmare_Exer {

    def main(args: Array[String]): Unit = {

        def f(s : String) : String = {
            return s + "Xenia"
        }
        println(f("Love "))

        def f1(s : String) : String = {
             s + "Xenia"
        }
        println(f1("Love "))

        def f2(s : String)=
            s + "Xenia"
        println(f2("Love "))

        def f4():String =
            return "Loky"
        println(f4())

        def f5(): Unit = {
            return "test Unit"
        }
        println(f5())

        def f6 {
             "test Unit"
        }
        println(f6)

    }

}
