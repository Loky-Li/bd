package com.atguigu.scala.p6

object Scala07_Object_Construct {
    def main(args: Array[String]): Unit = {
        //todo 面向对象 - 构造方法

        //尝试调用模拟的构造方法，观察是否打印
        // var user07:User07 = new User07()
        //通过测试后发现不打印，在Scala中，下面的只是一个名字是User07()的方法
        //所以调用User07()方法的正确方式如下：
        //user07.User07()

        //测试Scala构造方法中定义函数逻辑体是否执行
        var user07: User07 = new User07()
        //构造对象时，类的主体内容会执行，完成类的初始化
    }
}

//声明类
//声明构造方法，在类名后增加参数列表。
//Scala万物皆对象，万物皆函数。 声明类等同于声明函数
//todo 默认是空参构造，可以不加(),而根据函数的定义，当函数空参省略()，调用时也必须不带()。
// 但是空参构造则特殊，如果构造函数省略(),调用它创建对象时，小括号可有可无。
class User07() {

    /*    //模仿Java中的构造方法，声明和类同名的方法，权限为public，
        def User07(): Unit ={
            println("xxxx")
        }*/

    //todo ： Scala的构造方法 = 类的主体 + 函数的主体
    //Scala的构造方法，由于也可以看做是函数的主体，所以也可以定义逻辑体
    println("Scala07....")

    //声明属性（变量）//作为类的主体的角色
    var name: String = "雨宣"

}
