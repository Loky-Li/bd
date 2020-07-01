package com.atguigu.scala.p6

object Scala03_Import {
    def main(args: Array[String]): Unit = {
        // Todo 面向对象 - Import
        // 1、Java中 Import是导类， 而Scala中的Import 是真正的导包
        // 2、Scala中导入包中所有的类使用下划线代替星号
        // 3、Import关键字可以在任意地方声明。这样在需要带包的代码前再导包，就不用翻到顶部查看使用的类所在的包
        // 4、Import可以模仿Java中的静态导入：Breaks._
        // 5、import 可以在一行中导入多个类。这样import占用的界面就不会太多。import java.util.{ArrayList,List}
        // 6、import java.util._   和  import sql.util._  都写的时候，如果使用Date，
        //      程序就无法读取到Date属于哪个类： 使用 import sql.util.{Date => _, _},屏蔽了 Date类
        // 7、Scala中访问包中的类使用的包路径为相同路径，默认以当前的包为准
        //      如果不想使用相对路径，那么可以使用绝对路径，使用根路径： new _root_.java.util.HashMap
        // 8、给类改名：import java.util.{ HashMap=>JavaHashMap}

    }

}
