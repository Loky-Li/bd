package com.atguigu.scala.p8

object Scala03_Match2 {

    //todo 模式匹配 - match - 匹配类型
    //模式匹配在匹配的时候，不考虑泛型。唯一特别的是Array
    //注意：new Array[String]()在编译后没有泛型，所以匹配时需要考虑泛型


    def main(args: Array[String]): Unit = {

        //泛型擦除
        println(describe(List(1, 2, 3, 4, 5)))
        //即便不是传入Int类型也是匹配到 List[Int]，结果依然是List
        println(describe(List(1, 2, 3, 4, "5")))

        //数组例外，可保留泛型
        println(describe(Array(1, 2, 3, 4, 5, 6)))
        println(describe(Array("abc")))

/*        测试单独使用 下划线作为变量名时，发生的情况
        val _ = "test"
        println(_)
        missing parameter type Error:(22, 17) missing parameter type for expanded function ((x$1) => println(x$1))
        println(_)
        即println(_) 被当成是一个被使用至简原则简化的函数，无法被解析*/
    }


    def describe(x: Any) = x match {

        case i: Int => "Int"
        case s: String => "String hello"
        case m: List[Int] => "List"
        case c: Array[Int] => "Array[Int]"

       //下面的someThing是 下划线的别名。不使用下划线的原因是需要使用someThing作为变量来打印类型
            //如 describe(Array("abc")) 的打印结果是 ：something else [Ljava.lang.String;@3b6eb2ec
            //如果使用下划线的话，打印的结果是 ：<function1> ，（我暂时的理解见下面！）
        // 所以， _ 下划线好像不能单独作为变量名，因为它代表的含义太多了，见上面的测试。
       // case _ => "something else " + _
        case someThing => "someThing else " + someThing

    }








}
