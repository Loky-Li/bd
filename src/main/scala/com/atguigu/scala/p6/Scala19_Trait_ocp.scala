package com.atguigu.scala.p6

import java.io.{BufferedInputStream, FileInputStream}

object Scala19_Trait {
    def main(args: Array[String]): Unit = {
        var user = new User19()
        user.insert()
    }
    //现在需要扩展一个update功能，可以在User19类中再加一个方法，但修改了代码，违反了OCP原则，
    //但是如果将新功能写一个User19的父类或接口，User19需要加extends或implements声明，同样改变了代码
    //Java中的实现方式是：装饰者模式


}

class User19{
    def insert(): Unit ={
        println("insert user data....")
    }
//    def update(): Unit = {
//        println("update user data...")
//    }
}

//使用装饰者设计模式：类似IO，将原来的功能封装到一个扩展类中，包装原来的类
//new BufferedInputStream(new FileInputStream(""))

class User199(user:User19){

    //由于外界使用装饰类的对象，所以装饰者模式的装饰类中必须有被装饰类的所有方法，
    //但是为了保持逻辑继承准确，这些方法不能装饰类去实现，而是被装饰类来调用方法。
    def insert(): Unit ={
        user.insert();
    }
    def update(): Unit = {
        println("update user data...")
    }

    //如果被修饰类的方法很多，装饰者类的代码就很冗余，所以使用Java的装饰者模式还是很麻烦。
    //Scala提供了动态混入特质的方式（见Scala20）
}














