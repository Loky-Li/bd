package com.atguigu.scala.p8

object Scala05_Match_SampleClass {
    def main(args: Array[String]): Unit = {

        // todo - 模式匹配 - 样例类
        // 样例类的作用其实就是为了模式匹配
        // 所以和普通类的声明方式不一样

        println(Student("zhangsan").name)

        //Student("zhangsan").name = "wangwu"

    }

}

class User{}

//样例类使用case关键字声明
//样例类的构造参数列表不能省略
//看编译后发现Student样例类同样在Java底层
//当类声明为样例类时，编译器会自动生成伴生类和伴生对象，而且同时伴生类Student中生成了大量的方法
//样例类和普通类基本一致。而apply()如果声明在普通类中只是普通的方法，
// 无法作为生成对象的方法。apply() 是声明在 object 伴生类中才可以作为生成对象的方法
/*case class Student(){
    def apply(name: String): Student = new Student()
}*/
//todo 上面所说，样例类等同于普通类，但如果又想不使用 new 的方式创建对象，
// 而使用类似apply方式的方式直接获取对象，那么直接在样例类声明类的后面加上参数列表。
// 但是格式又有些和普通类定义构造不同
//通过编译后发现,当向样例类声明中传入参数， 伴生对象student$ 中
// 生成了对应传入参数的apply()方法，并返回Student对象，所以无需new
// public Student apply(String name) { return new Student(name); }

case class Student(name : String){
    //def apply(name: String): Student = new Student()
    //def apply(): Student = new Student()
}

//但是 以前 class Student(name : String)是声明类，同时也是一个方法，则 name是一个方法的参数，即局部变量，方法外不能访问
//但是在main中测试，样例类的Student对象却可以 直接 .name  的方式访问到name

//编译后发现 ： private final String name;
//样例类如果声明构造参数，等同于声明类的属性。所以方法外可以访问
// 而以前通过构造参数声明类的属性，需要 var/val等修饰。在样例类没有看到修饰符
// 同样编译中，生成的属性使用final修饰，说明样例类使用构造参数声明属性时，默认val修饰，并隐藏了。
// 当然，如果外部向修改这个属性的值，那么加上 var，不使用默认val即可
//case class Student(var name : String){ xxxx }

//所以工作中，声明类一般使用样例类。

