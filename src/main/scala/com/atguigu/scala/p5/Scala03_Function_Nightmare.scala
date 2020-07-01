package com.atguigu.scala.p5

object Scala03_Function_Nightmare {

    def main(args: Array[String]): Unit = {
        //todo 函数式编程 - 噩梦版   至简原则：能省则省

        def f1():String ={
            return "雨宣"
        }

        //Todo 1 、如果推断出函数的返回值 ，那么省略返回值类型
        //一般函数中不需要使用return语法，函数可以根据满足条件的最后一行代码最为返回值

        def f2() = {
//            "雨宣"
            val flg = true
            if(flg){
                12
            }else{
                "雨宣"
            }
        }
        f2()

        //todo 2、函数体只有一行代码，花括号可以省略
        def f3() = "雨宣"
        println(f3())

        //todo 3、如果函数中的参数列表无参，那么参数的括号也可以省略
        //注意：当省略了小括号时，调用方法的时候，也不能加小括号   ——> 统一访问原则，类似于变量的访问
        //而上面的 f3 的调用，在声明函数时有(),那么调用时，小括号可加可不加
        val name = "雨宣"
        def f4 = "雨宣"
        println(name)
        println(f4)

        //todo 4、如果函数返回值使用 Unit，函数不会采用最后一行代码作为返回值
        //如果想要省略Unit，但又不想使用最后一行代码作为返回值，那么等号也需要同时省略。
        // 否则使用的就是最后一行的值
        def f5(){

            "雨宣"
        }
        println(f5)
        //上面的()可以省略，但是为什么{}不能继续省略呢？




        //todo 5、如果不关心函数的名称，只关心函数的实现，那么可以省略函数名，使用匿名函数
        //下面为匿名函数的写法：   ()=> {println("XXX")}
        //匿名函数可以赋值给变量，通过变量来调用函数
        println("---匿名函数----")
        var f6 = () => {println("xxx")}

        f6()   //注意需要有括号





    }

}
