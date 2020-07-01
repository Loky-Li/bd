package com.atguigu.scala.p6
package xxx{

    class Test{
        def test():Unit ={
            print("test...")
        }
    }

    package yyy{
        object Scala02_Package {
            def main(args: Array[String]): Unit = {
                // Todo 面向对象 - Package
                //Java中 Package 的作用
                //1、分类管理
                //2、区分相同名称的类
                //3、访问权限

                //Scala语言对Package
                //1、包路径和源码所在的路径没有关系
                //2、package 关键字可以多次声明，多层目录，父包子包的概念，层次分明
                //3、package 可以嵌套使用  package P1{ package P2{ 代码} }
                //4、子包可以直接使用父包中的内容，不需要导包。但是父包使用子包的时候需要导包
                //5、java.lang.* / scala.* / Predef.*  无需导入
                //6、scala完全面向对象，所以package 也是对象。需要在package对象中声明变量的话，创建 package object 类
                //      包对象的作用是，其内定义的变量、方法，可以被包中的所有类使用 （见文档，课堂说得不够详细）
                //7、权限：Scala中
                //      什么都不写表示 public
                //      private和 java的作用一样
                //      private[ 包名 ] 包权限， 和 Java中的 缺省 类似 ，但是 scala 可以指定包和子包来访问
                //      protected 只能给当前类和包的子类使用，同包不能使用
                println("xxxx")

                new Test().test()  // 子包直接使用父包中的内容
            }

        }
    }
}


