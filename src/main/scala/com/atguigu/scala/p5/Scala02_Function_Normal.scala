package com.atguigu.scala.p5

object Scala02_Function_Normal {

    def main(args: Array[String]): Unit = {
        //todo 函数式编程

//1、函数无参数，无返回值
        def f1(): Unit = {
            println("f1...")
        }
        f1()

//2、函数有参数，无返回值
        def f2(name : String): Unit = {
            println(s"name = $name")
        }
        f2("Yuxuan")

//3、有参数，有返回值
        def f3(i : Int) : Int={
            return  i + 20
        }
        println(f3(20))

//4、函数无参，有返回值
        def f4():String={
            return "Yuxuan"
        }
        println(f4())

//5、函数有多个参数，有返回值
        def f5(i:Int, j:Int):Int={
            return i + j
        }
        println(f5(1,4))

//6、函数有返回值，类型不确定
        //Scala 可以简化函数的声明，采用  至简原则
        def f6(b: Boolean):String={
            if(b){
                return null
            }else{
                return "Yuxuan"
            }
        }

//7、可变参数
        def f7(i:Int *): Unit = {
            println(i)
        }
        f7(3,654,23,6)

/*        //7、可变参数必须放在最后，和Java一样的原则。否则会有歧义
        def f77(i:Int *, j:Int): Unit = {
            println(i)
        }*/

//8、参数的默认值
        //todo 函数的所有参数都默认为val

/*        def f8(name : String): Unit = {
            if(name == null){
                name = "zhangsan"   //这会报错，显示参数是声明的 val 不可变类型
            }
            println(s"name = $name")
        }*/
        def f8(name : String = "Yuxuan"): Unit = {
            println(s"name = $name")
        }
        f8("Dunhong")
        //todo 下面的格式特别容易忘记：会误以为：函数没有传参数，会报错，会者调用了其他重载的函数。
        // 而实际上直接使用函数的默认值。并并且函数时没有重载的！
        // 这个点在后面学构造函数时，忘了，然后就犯了上面的疑惑
        f8()

//9、有多个参数，并且需要使用部分参数的默认值

        def f9(age:Int,name : String = "Yuxuan"): Unit = {
            println(s"name = $name" + s", age = $age")
        }
        //上面将没有默认值的参数移动到了最前面的，通过Scala的参数匹配规则是，从左到右读取
        f9(25)

        //带名参数：如果有默认值的参数放在了后面，在调用函数时，
        // 为了使用到默认值，可以通过给没有默认值的参数显示地使用参数名，见下面
        def f99(name: String = "Yuxuan" , age:Int ): Unit = {
            println(s"name = $name" + s", age = $age")
        }
        f99(age = 25)      //打印的效果和上面的一样

        def f100(name: String ){
//            name = "List"
            println(name)
        }



    }

}
