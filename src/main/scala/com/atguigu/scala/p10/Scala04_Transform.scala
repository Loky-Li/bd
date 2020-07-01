package com.atguigu.scala.p10

import scala.math.Ordering

object Scala04_Transform {
    def main(args: Array[String]): Unit = {

        //todo - 隐式参数

        //将方法参数的前面增加 implicit，这个参数称为隐式参数。
        // 如果想要动态改变参数的默认值，需要使用隐式变量。
        // 这样后续更改时，也不需要改变定义方法参数的代码。
        def regUser(implicit password:String ="123123"): Unit ={
            println("insert user("+ password + ")")
        }

        //隐式变量对隐式参数的默认值做修改
        // 改后的值仍然是方法参数的默认值，在调方法时会使用到该默认值
        //隐式转换只和类型有关，和参数名无关。（下面两句只能有一句，因为隐式转换只能有一个转换规则）

//        implicit val password:String = "000000"
        implicit val xxxxxx:String = "xxxxxx"       //regUser的参数password的默认值被改为xxxxx


        //todo  隐式变量的使用，不能在调用函数时增加小括号。否则隐式变量没有被修改生效
        regUser             //insert user(xxxxxx)，没加小括号，使用隐式参数，而隐式参数的值由后面的隐式变量修改了。
        //如果注释掉implicit val xxxxxx:String = "xxxxxx"，隐式参数的值即为初始的默认值

        //下面的方式会让编译器以为手动传入参数，所以隐式参数就
//        regUser()   //insert user(123123)  //不使用隐式参数，即使用的是参数初始默认值


        //前面学习的例子中有这样的用法：实现对List的元素进行降序排序（sortBy默认是升序）
        val ints = List(1,3,2,4)

        println(ints.sortBy(num => num)(Ordering.Int.reverse))
        ints.sortBy(num => num)(Ordering.Int.reverse)       //----①
        ints.sortBy(num => num)                             //----②

//        看sortBy的源码，第二个参数就是隐式参数
        //sortBy[B](f: A => B)(implicit ord: Ordering[B])。
        //而①表示明确传入参数，所以就不使用隐式参数。
        // 而②没有加小括号，所以使用隐式的参数，即升序规则。
        // 如果②后面加小括号，里面一定需要明确地给定参数。

    }

}
