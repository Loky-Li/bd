package com.atguigu.scala.p8

object Scala02_Match {


    def main(args: Array[String]): Unit = {
        //todo 模式匹配 - match - 守卫

        //Scala中的模式匹配，不仅可以匹配值（字面量），还可以匹配数据类型
/*        def abs(x: Int) = x match {
            case i: Int if i >= 0 => i
            case j: Int if j < 0 => -j
            case _ => "type illegal"
        }

        println(abs(-5))*/

        def abs(x: Int) = x match {
            case i: Int if i > 0 => i
            case j:Int if j < 0 => -j
            case _ => "type illegal"
        }

        println(abs(-34))
       // println(abs("feje"))
        // todo 上面报错：自己开始误以为守卫模式是对传入的参数类型进行守卫
        //然后在测试自以为是的对类型进行守卫的时候，发现启示类型传错还是会报错
        //真正的守卫模式是对传入的参数的值范围进行匹配

        //然后我就认为前面的 i:Int 可以省略，但是下面尝试后发现报错。
        // 所以在使用守卫模式的时候上面的应该是固定格式（没有更多的参考案例，所以暂时这样理解）
/*        def abs2(x: Int) = x match {
            case if i > 0 => i
            case if j < 0 => -j
            case _ => "type illegal"
        }*/

        def testStr(s:String) = s match {
            case s:String if s.startsWith("H") => "Hello"
            case s:String if s.startsWith("G") => "Good"
        }

        println(testStr("Heedf"))

    }

}
