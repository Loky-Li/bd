package com.atguigu.scala.p6

object Scala25_Enum {
    println("xxx")
    def main(args: Array[String]): Unit = {
        println(Color.RED)

    }
}

// 枚举类
object Color extends Enumeration {
    val RED = Value(1, "red")
    val YELLOW = Value(2, "yellow")
    val BLUE = Value(3, "blue")
}

// 应用类 App。Scala中的main方法并不是和Java中的main方法时程序的入口，只是伴生对象的一个普通方法
//所以在类内，main方法前面可以定义其他的逻辑，并可以执行，但是语义上就有些奇怪
//所以Scala就提供了App应用类来执行这些特殊的逻辑，这个类和其他的普通类不同，它本身无需main方法就可以执行
object MyApp extends App {
    println("xxxx")
    println("xxxx")
}
