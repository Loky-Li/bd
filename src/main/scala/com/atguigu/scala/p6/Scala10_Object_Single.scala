package com.atguigu.scala.p6

object Scala10_Object_Single {
    def main(args: Array[String]): Unit = {
        //todo 面向对象  - 构造方法  - 实现单例

        //User10的构造方法已经private，下面通过构造方法获取对象的方式会报错
        //val user = new User10()

        val user = User10.newInstance()
        println(user.name)

        //验证构造方法就是声明类，无参构造时，小括号有无都可以。和其他函数不同的点
        val user1 = new User100
        val user2 = new User100()

    }
}

//单例：为了实现外界无法直接使用构造方法构造对象
//将构造方法私有，如果在class前面加private的话，会变成私有类，而不是私有构造方法
//在 （）前面加上private


class User10 private(){
    var name : String = "雨宣"
}

//在java中实现获取私有化对象的方式是：类内部提供一个公共的静态方法，可以返回该单例的私有对象。
// 外界直接通过   类名.静态方法 来获取类的对象
//而Scala中通过伴生对象来模拟Java的类直接访问静态方法。
//即伴生对象访问伴生类（现在的私有类）中的私有内容
object  User10{
    def newInstance() : User10 ={
        //伴生对象可以访问伴生类的私有构造方法，所以下面构造对象没毛病
        new User10()
    }
}


//理解文档中：6.2.6 构造器，1），（2）Scala中构造方法其实就是类的声明
//比如下面的类，在声明时，其实就是无参构造，并且省略了(),
//而构造方法就是一种函数，当函数无参，省略()时，在调用函数时，也必须没有小括号，但是在上面
//—main方法中，发现调用构造函数，构造user100的对象时，有无小括号都不会报错。这是构造函数的特殊小点，硬记。
class User100{

}
