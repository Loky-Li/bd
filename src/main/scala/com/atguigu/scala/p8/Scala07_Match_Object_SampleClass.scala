package com.atguigu.scala.p8

object Scala07_Match_Object_SampleClass {
    def main(args: Array[String]): Unit = {

        //todo - 模式匹配 - 匹配对象

        val user = User("zhangsan",11)
        val result = user match {
            case User("zhangsan", 11) => "yes"
            case _ => "no"
        }
        println(result)
    }

    //只需要声明一个样例类，底层就已经实现了大量的方法
    case class User(val name: String, val age: Int)

/*  使用了样例类后，下面的这些代码都无需自己写了
   object User{

        // 应用： 传入参数 => 返回对象
        def apply(name: String,age: Int): User = new User(name, age)

        // 提取 ： 传入对象 => 返回参数
        def unapply(user: User): Option[(String, Int)] = {
            if(user == null)
                None
            else
                Some(user.name,user.age)
        }
    }*/
}
