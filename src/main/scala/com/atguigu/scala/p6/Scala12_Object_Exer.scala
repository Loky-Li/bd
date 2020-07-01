package com.atguigu.scala.p6

object Scala12_Object_Exer {
    def main(args: Array[String]): Unit = {

        // TODO 面向对象 - 继承
        //求下面创建对象后的打印内容
        new User12()

    }
}

class Parent12() {
    println("1111")
    def this( name : String ) {
        this()
        println("2222")
    }
}
class User12(name:String) extends Parent12(name) {
    println("3333")
    def this( ) {
        this("xxxxx")
        println("4444")
    }
}

//分析：①：先看调用的是有参还是无参构造，再看调用的构造函数时主构造函数还是辅助构造
//如果是辅助构造函数，还需要再直接或间接调用主构造函数来实现初始化
// ②：调用子类的构造方法的时候，需要父类的构造方法先初始化。

// 1111
// 2222
// 3333
// 4444
