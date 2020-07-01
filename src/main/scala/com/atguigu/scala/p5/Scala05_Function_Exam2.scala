package com.atguigu.scala.p5

object Scala05_Function_Exam2 {

    //课堂测试：输入一个字符串，输出它的首字母大写格式。要求：使用至简原则来一步步优化
    def main(args: Array[String]): Unit = {
        val s = "zhangsan"

        def f(ff:(String) => String): Unit ={
            println(ff(s))
        }

        println("-----------完整版，定义函数，传入-----------")
        //完整版 定义一个 和 f的函数签名参数 匹配的函数 f1 ,
        def f1(s: String) : String ={
            s.substring(0,1).toUpperCase()
        }
        //调用验证
        f(f1)

        //注意：f1中的参数s并不是定义的字符串s。这个开始有疑惑，认为不是定义的s，那怎么处理到指定的s
        //解疑：在函数f中，已经将s传入到了 它的 参数函数 ff。也就是指定了处理的字符串就是s。

        println("------------匿名函数版： ①完整版 ------------------")
        //如果功能变化，如实现的逻辑不同，需要输出首字母小写，那么又得重新定义一个函数。
        //所以引入了匿名函数，让代码更加灵活

        f((s: String) => {s.substring(0,1).toUpperCase()})

        println("------------匿名函数版： ②简化，去掉花括号{ }------------------")
        f((s: String) => s.substring(0,1).toUpperCase())

        println("------------匿名函数版： ③ 去掉 参数类型------------------")
        f((s) => s.substring(0,1).toUpperCase())

        println("------------匿名函数版： ④ 去掉 只有一个参数的 小括号------------------")
        f(s => s.substring(0,1).toUpperCase())

        println("------------匿名函数版：⑤ 处理逻辑中，参数使用一次，且顺序和定义顺序一致，将 => 及其左边的内容去掉------------------")
        f(_.substring(0,1).toUpperCase())

    }

}
