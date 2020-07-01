package com.atguigu.scala.p6

import scala.beans.BeanProperty

// TODO 理解Java中的动态绑定：更正了很对以前对Java的理解
// 详细看 java 文件目录下的 TestOverwride
object Scala05_Class1 {
    def main(args: Array[String]): Unit = {
        
        // TODO 面向对象 - class - 方法
        
        val emp = new Emp1()

        emp.test("ssssss")
    }
}

class Emp1 {
    // 声明方法
    // 方法可以重载和重写
    def test(): Unit = {
        println("xxxxx")
    }
    
    def test( s : String ): Unit = {
        println("s = " + s)
    }
}