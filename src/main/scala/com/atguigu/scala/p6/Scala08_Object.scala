package com.atguigu.scala.p6

object Scala08_Object {
    def main(args: Array[String]): Unit = {
        //todo 面向对象  - 构造方法  - 辅助构造方法

        val user01 = new User08()
        val user02 = new User08("zhangsan")
        val user03 = new User08("xenia",25)


    }
}

//Scala中的构造方法分为两大类：主构造方法 & 辅助构造方法
//在列名后增加参数列表的方式，称之为主构造方法，主要目的用于类的初始化

//在类中声明的构造方法称为辅助构造方法，用于辅助主构造方法完成一些初始化操作，类似Java中构造方法的重载
//辅助构造方法的声明采用关键字this来声明
//辅助构造方法不能直接构建对象，没有办法完成类的初始化，必须直接或间接调用主构造方法！！

class User08(){
    //todo ： Scala的构造方法 = 类的主体 + 函数的主题

    //声明属性（变量）
    var name : String = "雨宣"

    def this(name: String){
        this()      ////经过测试：this()必须显示地写出（和java默认调用空参构造不同）
    }

    //下面类似Java中的构造方法调用其他构造方法。Java中调用和被调用的构造方法并没有先后之分
    //但在Scala中：被调用的构造方法，必须提前声明，否则下面的构造方法无法调用
    //Scala中的构造方法，调用其他构造方法时，同样使用this关键字
    def this(name: String, age: Int){
        //通过带参构造，间接访问主构造方法，实现初始化
        this(name)
    }



}
