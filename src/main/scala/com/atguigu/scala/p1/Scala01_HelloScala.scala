package com.atguigu.scala.p1


// Scala是完全面向对象的语言，没有静态语法，所以没有static这个关键词
// Scala中如果一个类使用object声明，编译时会产生两个类文件
// 第一个类文件是当前类名的编译class文件
// 第二个文件是当前类名加上$ 的编译的class文件，运行时，会使用单例模式创建单一对象进行方法调用
// 所以有时会将使用object关键字声明的类型称为伴生对象
// 将生产伴生对象的那个类称为伴生类，使用class声明
// Scala采用object关键字来模拟java的静态语法，可以通过类名直接访问方法。
object Scala01_HelloScala {

  def main(args: Array[String]): Unit = {


    System.out.println("Helllo Scala!")
  }

}
