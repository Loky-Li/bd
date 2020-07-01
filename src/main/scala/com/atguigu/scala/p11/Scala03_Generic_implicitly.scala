package com.atguigu.scala.p11

object Scala03_Generic_implicitly {
    def main(args: Array[String]): Unit = {

        //todo implicitly - 从上下文中取出隐式转换的值

        def test(implicit  name: String): Unit ={
            println(name)

        }

        //使用隐式变量对隐式参数的默认值做改变
//        implicit val nameTest:String = "Xenia"
//        test

        //将上面的隐式参数放在其他包中并import
        //todo 使用implicitly来读取引入的包中的变量，即读取上下文 的信息

        import com.atguigu.scala.p1.Scala04_Var._

        //在当前的环境中，找到指定类型的隐式参数
        val str: String = implicitly[String]

        test

        //老师使用的是下面的方式，在获取了str后，指定传入使用 implicitly 上下文限定获取的值
        test(str)

        //两种方式都可以，说明使用上下文限定 获取的隐式变量也可以对函数中的隐式参数做修改。

        //todo 在AnyVal中就有一个类型 StringOps，它就是通过隐式转换将String类型转成StringOps类型。
        // 在Predef中看源码：
        // implicit def augmentString(x: String): StringOps = new StringOps(x)
    }

}
