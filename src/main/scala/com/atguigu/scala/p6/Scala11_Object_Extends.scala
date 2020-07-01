package com.atguigu.scala.p6

object Scala11_Object_Extends {
    def main(args: Array[String]): Unit = {
        //todo 面向对象  - 继承

        var user:User11 = new User11("雨宣")

    }
}

//todo 父类中的属性和方法一般使用protected来声明访问权限
//Scala中protected修饰变量和方法时，只给同类和其他包子类访问，不会被同包下其他类访问。——
//——上面是对Java中protected的升级，因为Java设计Protected的初衷就只是想给不同包的子类访问。但是没有屏蔽到同包下的其他类


class Parent11(name : String){

    println(s"name = $name")

}

//Scala的继承同样使用 extends，“类”同样也只支持单继承
//上面加上“类”的原因是：说Java的继承时单继承是不对的，因为接口可以多继承，所以指明是类单继承

//继承父类的有参构造，
//构造方法：子类必调父类的构造方法，无参的已经隐藏默认，但是如果父类的构造方法有参,子类必须显示调用

//Java中是使用super关键字，Scala中在继承的时候，直接在类声明上继承的父类，加上参数列表即可。  --------①

//todo    class User11(name:String) extends Parent11("Xenia"){}

//而Java中通过子类的带参构造的参数，super(xxx) 后实行参数传入到父类
//Scala如果想要子类的参数传递给父类的构造方法，直接传递即可。----------②
//综合①和②后，得到下面的写法。 并在main方法中验证
class User11(name:String) extends Parent11(name){}