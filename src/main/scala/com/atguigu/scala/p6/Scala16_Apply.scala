package com.atguigu.scala.p6

object Scala16_Apply {

    def main(args: Array[String]): Unit = {

        //使用new构建对象时，等同于调用类的构造方法
        val user = new User16()

        //上面的写法和Scala面向对象的设计有些违和，
        // 所以Scala中还可以使用伴生对象的apply方法来直接构建类对象
        val user1 = User16.apply()
        // Scala可以自动识别伴生对象的apply方法，所以apply方法可以省略
        //省略后，在底层编译中，编译器会自动调用apply()的方法
        val user2 = User16()

        // todo apply方法不能省略参数列表的小括号，否则会导致使用有问题
        //在调用apply时，由于方法省略()，调用也不能有()。
        //而如果在创建对象时省略apply，又不加(),就变成下面的写法
        //val user2 = User16  —— 最终打印可以看到，user2对象时 User16$ 类型，并不是需要创建的User16
        //todo 自己测试后发现，如果在类中坚持使用自动生成的不带()的apply方法，那么创建User16对象时
        //只能使用  val user1 = User16.apply , 这时候就不能省略apply，否则会出现上面的错误,获取不到想要的对象

        //测试apply构造带参对象
        val user3 = User16( "Dunhong" )

        println(user1)
        println(user2)
        println(user3)

        //在Scala中apply很常用，比如Range：可以通过new Range(1,5,2)或Range(1,5,2)两种方式创建Range对象
        //当使用前者时，使用的是调用构造，后者则是使用apply()的方式构造对象


    }

}

//理解下面的声明：整个带参的构造函数，并且函数参数中赋默认值
class User16(name: String="zhangsan"){
    println(name)
}

object User16{
    //自动生成的apply后面没有()，需要自己手动加的，原因见上面的分析
    //
    def apply(): User16 = new User16()
    //将class User16改为带参的构造后，上面的无参apply()没有报错，那么他对应的无参构造函数再哪里呢？
    //是不是可以理解为：在 object User16有两个类 class User16 和 class User16$()
    //那么这样不就是和Java中一样，两个构造函数可以并列写，不是和Scala中主构造和辅助构造的写法矛盾吗？
    //通过测试后发现val user2 = User16()这种方式，也会打印name的默认值zhangsan，说明使用apply()时还是会走带参构造
    //为什么呢？是否就意味着apply()的空参构造时辅助构造，而带参的是主构造呢？

//    todo 释疑：见 p5_Scala02 中 的方法/函数 的默认参数。
//    当使用new User16() 时，由于class User16(name: String="zhangsan"){xxx} 中，构造方法的参数是有默认值
//    直接调用方法，这个有默认值的参数，可以不显示写出，即new User16() 实际为 new User16(name: String="zhangsan")
//

    def apply(name: String = "zhangsan"): User16 = new User16(name)
}

