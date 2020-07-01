package com.atguigu.scala.p2

object Scala02_String {

    def main(args: Array[String]): Unit = {

        var name : String = "Xenia"
        var age : Int = 25

        //json => {}

        println(name)
        print(age)

        println(name + " " + age)

        println("-------1-----------")

        println("--------3-----------")

        //写成Json格式 =>{"name":Xenia,"age":25}
        //需要转义，
        // println("{\"name\":Xenia,\"age\":25} ")
        //上面的写法很乱，如果字符串再长的话，会造成很乱。在Scala中使用了插值运算
        println(s"name=$name")
        //当要对引用的字符串处理时使用 ${}
        println(s"name=${name.toUpperCase()}")      // EL 表达式

        println("--------4-----------")
        //当要使用tab和换行的时候，以前的写法是
        println(s"name=$name \t" + s"\n age=$age")
        //Scala中提供了很简便的方式可以实现

        val s =
            """
              |select
              | name,
              | age
              |from  user
              |where name="zhangsan"
            """.stripMargin
        println(s)

        val s1=
            s"""
               |select
               |    name,
               |    age
               |from user
               |where name="$name"
               |
             """.stripMargin

        //printf 的用法知道即可
    }

}
