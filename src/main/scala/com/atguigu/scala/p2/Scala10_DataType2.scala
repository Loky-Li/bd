package com.atguigu.scala.p2

object Scala10_DataType2 {

    def main(args: Array[String]): Unit = {
        //todo

        var c: Char = 'A'
        //  var cc : Char = c + 1
        //  上面报错，原因：c是变量，变量在运算时自动提升为Int，则 c+1 的结果是 Int类型，赋值给 char类型报错
        //下面不会报错的原因：编译时自动做计算，类似将‘A’+ 1 当成一个整体，如果结果在char的范围内，那么就不会报错。
        //如 Int i = 1 + 1 + 1，在底层处理时，并不是一步步相加，而是编译时直接自动计算，将 1 + 1 + 1 得到为 3，然后直接赋值给 i
        var cc: Char = 'A' + 1
        println(cc)
    }

}