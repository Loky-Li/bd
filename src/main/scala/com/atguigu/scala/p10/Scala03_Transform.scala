package com.atguigu.scala.p10

object Scala03_Transform {
    def main(args: Array[String]): Unit = {
        //todo 隐式转换：将A 类型 => B类型
        // 如果函数使用implicit关键字，那么这个函数称之为隐式函数
        //todo 隐式转换传入的参数只能有一个：如果有多个参数类型需要转换，可以使用函数柯里化来实现
/*        implicit def test(i: Double,s:String): Int ={
            i.toInt
        }*/

        implicit def test(i: Double): Int ={
            i.toInt
        }

        //todo  隐式转换的规则不能出现多次，否则会出现错误。
        // 因为如果有2个隐式转换，编译器在二次编译时无法确定使用哪个转换
/*        implicit def test1(i: Double): Int ={
            i.toInt
        }*/

        //todo  注意上面是定义两个 A类型 => B类型 的隐式转换会出错。
        // 而下面是 A类型 => C类型，所以不冲突！
        implicit def test1(i:Double):Long ={
            i.toLong
        }

        implicit def test2(i:Double):Long ={
            i.toShort
        }

        val i:Int = 2.0
        println(i)
    }

}
