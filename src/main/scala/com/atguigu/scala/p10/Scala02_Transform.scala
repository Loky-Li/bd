package com.atguigu.scala.p10

object Scala02_Transform {
    def main(args: Array[String]): Unit = {

        //todo 在很多的功能拓展中都使用到隐式转换。
        // 还可以对自定的类进行隐式转换

        val user = new User()
//        val user = new ExUser()       //但是这个写法也改变了源码，不符合OC原则
        //实现插入的功能
        user.insert
        //现在需要实现update功能
        user.update

        //通过隐式转换将User类在二次编译中转成ExUser类。之后上面调用update方法就不会报错
        implicit def transform(u:User): ExUser = {
            new ExUser()
        }

    }

    class User{
        def insert: Unit ={
            println("insert data...")
        }
        //现在需要新增一个更新用户的功能，可以直接在下面新加代码块
        //但是这样的方式对代码做了修改，不符合开发的开闭原则
/*        def update: Unit ={
            println("update data...")
        }*/

    }

    //原来的Trait时的实现方式是：动态混入,新声明一个特质tail，见 p6-Scala20
    // 之后在创建对象时混入新的特质，使对象具有新特质的功能：var user = new User20() with Trait20

    //现在：新加一个类
    class ExUser{
        def update: Unit ={
            println("update data...")
        }
    }

}
