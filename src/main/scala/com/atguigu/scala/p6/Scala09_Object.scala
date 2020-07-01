package com.atguigu.scala.p6

object Scala09_Object {
    def main(args: Array[String]): Unit = {
        //todo 面向对象  - 构造方法  - 带参构造

        var user = new User09("雨宣")

        println(user.username)
        println(user.name)
    }
}

//Java中使用有参构造方法的目的：类外部的属性(name) 赋值给类内部的属性(this.name),构造后的对象拥有该属性值
//      构造有对应变量值的对象，即初始化类对象。使用的是 this.name = name.
//下面的Scala代码就是通过模拟Java中的带参构造，并将外部参数传入到构造的参数中，实现对构造方法内属性的赋值的方式
//发现报错，原因：Scala的构造方法即是 类主体 + 函数主体，所以参数中的name和var 声明的 name都是局部变量，
//而在函数中不能有两个同名的局部变量，所以报错
/*class User09(name : String){
    var name : String = name
}*/
//Scala中的解决方式：
//既然使用带参构造的目的是给构造方法内的参数直接赋值，Scala直接将需要被初始化赋值的属性声明在构造方法的参数中

class User09(var username : String){

    //通过main方法中可以知道User09有两个属性username和name
    //通过反编译可知，下面是通过调用username的getter方法后赋值给name属性
            /*    private String username;
                private String name = username();*/
    var name : String = username
}

