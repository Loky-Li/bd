package com.atguigu.scala.p7

object Scala02_Array {
    def main(args: Array[String]): Unit = {

        //todo 集合 - Array - 数组（不可变）
        //创建数组 - 1  ： 使用new 的方式
        val array = new Array(3)
        //创建指定类型的数组，使用泛型：如String数组
        val strings: Array[String] = new Array[String](3)

        //创建数组 - 2 ： 使用apply的方式
        val ss:Array[String] = Array("1","2","3")    //--省略apply，默认调用

        //元素操作
        //访问数组元素，需要采用小括号来定位
        strings(0) = "Xenia"
        strings(1) = "love"
        strings(2) = "Loky"


        //增加数据
        //数组可以添加数据,但是添加后会产生新的数组,内存中有新的对象，所以Array是不可变的
        val strings1 = strings :+ "d"   //Xenia,love,Loky,d
        //val strings1 = "d" :+ strings     //d,[Ljava.lang.String;@3796751b

        //Scala中的运算符如果使用冒号结尾，那么调用的顺序为从右到左
        val strings2: Array[String] = "e" +: strings
        //"e" +: strings  相当于 strings.+:(e)，见下面：
        val strings3: Array[String] = strings.+:("e")    // er .+:  后面的值是添加在前面
        //todo  记忆小结： 理解上面冒号的位置来推断出完整的预算符。
        // 通过val strings1 = "d" :+ strings 测试后发现，结果为：d,[Ljava.lang.String;@3796751b
        //真的好难理解 :+ , 记住引用类型必须放在 :+ 前面就可以了。 否则放在后面的话，添加的是地址值
        //todo 在Scala05的代码后，理解了 .+:()  和 +：
        //  .+:  表示的是集合或字符串添加一个任意类型元素。数字没有这个运算方法，所以当向集合中添加数字时
        //只能使用 .+: 的方式，如 list.+:(5)，而简化后就是 5 +: list。
        // 虽然 +： 是对方法 .+:() 的简化后颠倒方向，但是 +: 更加直观，因为操作符前后顺序，就是结果值的前后顺序



        //集合打印
        println(array)      //观察发现是object数组,和Java中创建数组后打印数组的结果一样
        println(strings)    //编译后发现是一个string数组

        //循环打印
        for(s <- strings){
            println(s)
        }

        println("---------使用foreach----------")
        //todo 循环遍历的一步步简化写法：

        //先定义一个打印字符串的函数
        def loop(s:String): Unit ={
            println(s)
        }
        //调用数组的foreach的方法，方法的参数使用一个函数
        //--①：完整版，传入定义的函数loop
        //strings.foreach(loop)
        //--②：匿名函数的完整本：
        //strings.foreach((s:String) => {println(s)})
        //--②:第一次简化：省略参数的类型 + 省略大括号  + 只有一个参数省略小括号
        //strings.foreach( s => println(s))
        //--②:第二次简化：参数在逻辑中只使用一次，而且出现顺序和定义的顺序一致。使用下划线代表参数
        //strings.foreach(println(_))
        //todo -- ②：第三次简化（这在前面没有接触过）
        strings.foreach(println)

        println("-------使用mkString-----------")
        //使用mkString的方法来打印数组的每一个元 素,并指定分隔符
        println(strings.mkString(","))

        println(strings1.mkString(","))
        println(strings2.mkString(","))
        println(strings3.mkString(","))


    }

}
