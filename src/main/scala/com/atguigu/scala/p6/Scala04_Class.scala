package com.atguigu.scala.p6

import scala.beans.BeanProperty

object Scala04_Class {
    // TODO 面向对象 - class

    val emp = new Emp()
    // 当给对象属性赋值的时候，等同于调用底层属性的set方法
    //emp.name = "zhangsan"
    //emp.age = 20
    //emp.email
    // 当获取对象属性值的时候，等同于调用底层属性的get方法
    //println(emp.name)
    //emp.age = 30

    // 标准的javabean规范中要求属性应该有对应的set，get方法
    // set方法必须以set开头，get方法必须以get开头
    // Scala为了解决javabean通用的问题，提供了属性的注解@BeanProperty

}

// scala声明类不需要使用public,而且可以多次声明
// Scala中的类也可以继承父类 : extends
class Emp {

    // 如果属性使用注解，那么编译时会自动生成对应set，get方法以及符合javabean规范的set,get方法
    @BeanProperty
    var id : Int = _
    // 声明属性
    // 编译时会给当前类声明私有的属性，并同时声明属性的公共的set，get方法
    //  getter : 属性名()
    // public String name() { return this.name; }
    // setter  ：属性名_$eq(参数) 理解为 name_=( xxxx )
    //def name_$eq(x$1: String): Unit =  { this.name = x$1}
    // private String name = null;
    //var name : String = _
    // 如果想要属性可以默认初始化,可以采用下划线赋值
    // 如果使用val声明属性，必须显示初始化
    // 当属性采用val声明，那么底层编译时，会给属性声明为final,而且不会生成set方法，就无法修改
    //val age : Int = 10

    // 如果给属性声明为私有访问权限，那么编译时，属性和对应的set，get方法的访问权限全都是私有的。
    //private var email:String = _
}



