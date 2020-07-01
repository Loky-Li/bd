package com.atguigu.scala.p5

object Scala09_Function_TestCurry {

    def main(args: Array[String]): Unit = {

        //todo  函数式编程 - 柯里化实现 f(10)(20)(xxx) => 200

        //完整的格式：老师在课上的逻辑特别舒服清晰。
        //注意：在写多层的函数嵌套的时候，不要先把返回值确定，也不要 直接 {}后回车
        //上面会认为返回值类型是Unit。而应该是使用 ={}后再回车，让类型自动推测
        // （返回值类型是函数的话，自己写特别复杂，看IDEA显示的就知道了）

        println("-----多层函数嵌套并作为返回值的普通写法-----")
        def f(i:Int) ={
            def f1(j:Int) ={
                def f2(f3:(Int,Int) => Int):Int ={
                    f3(i,j)
                }
                f2 _
            }

            f1 _
        }

        println(f(10)(20)(_*_))


        //使用函数柯里化来实现对多层函数嵌套的简化
        println("-----使用函数柯里化来简化写法------")

        def ff(ii: Int )(jj : Int)(t:(Int,Int)=>Int):Int ={
            t(ii,jj)
        }

        //调用柯里化后的函数
        println(ff(10)(20)(_*_))





    }


}
