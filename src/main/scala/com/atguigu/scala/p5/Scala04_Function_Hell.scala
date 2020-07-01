package com.atguigu.scala.p5

object Scala04_Function_Hell {

    def main(args: Array[String]): Unit = {
        //todo 函数式编程 - 地域版
        //Scala完全面向函数，所以万物皆函数
        //函数什么都可以做： 变量，参数，返回值

        // todo 函数作为一个变量

/*        def f1(): Unit = {
            println("f1...")
        }

        println("------")
        //...
        //val f = f1()
        //val f = f1
        //println(f)    //返回的是 ()  即函数的返回值



        println("------")
        //如果想将整个函数 (下划线前面需要有空格)
        val ff = f1 _
        println(ff)

        //之后通过调用变量来调用函数
        ff()

        //当声明了变量的类型，不需要下划线
        // 如下面的 f 的参数类型，已经指明了是一个函数，所以 f1 无需 再使用 下划线
        var f: ()=>Unit = f1
        f()

        //todo 2、函数最为参数来使用
        //函数的参数也是一个函数： 函数( 函数名 ： 函数类型)
        //函数类型：（参数列表）=> 返回值类型
        def f2(f: (Int,Int) => Int): Unit = {
            f(10,10)
        }

        def f22(i:Int, j: Int): Int = {
            i + j
        }
        println(f2(f22))

        //由于只需要使用 f22的逻辑，为不需要函数名
        println(f2(  (x:Int,y:Int) => {x+y} )  )*/

        // todo 3、将函数的整体作为返回值


//        def f(s : String): Unit ={
//            println("f.....")
//        }
//
//        def f1()={
//            f _      //如果只是写 f， 那么就是 f() 省略括号，就相当于是函数的结果值。
//        }
//
//        //f1()函数的返回值，也是一个函数，所以后面需要加上（），即第二个（）表示的是“返回的函数”
//        f1()("Xenia")
        // 分2步：① f1() 得到一个结果，为一个函数。  ② 将①中得到的返回值，即函数，放入参数。

//        上面的可以写成下面的方式：也是函数柯里化的原理

/*
        def f1() = {
            def f(s : String):Unit = {
                print(s)
            }

            f _
        }
*/

        //TODO 4、 函数柯里化的原型：将函数的整体作为返回值，且有多层时。
        //外界分别传入两个数，并给定逻辑
        def f1(i: Int) = {
            def f2(j : Int) = {
                def f3(f:(Int,Int) => Int) = {

//                   println(f(i,j))

                    //或者是下面的写法
                    val h = f(i,j)
                    println(h)
                }
                f3 _
            }
            f2 _
        }
        f1(10)(20)(_+_)



    }

}
