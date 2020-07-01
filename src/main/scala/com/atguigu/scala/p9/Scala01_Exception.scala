package com.atguigu.scala.p9

object Scala01_Exception {
    def main(args: Array[String]): Unit = {
        //todo 异常。
        // java中的异常见TestExecption。还有一个易错的异常案例 TestFinally
        //Scala中异常采用的也是模式 匹配，省略了match关键字
        //Scala中异常没有分类，所以不需要在编译时提示，所以也就没有了throws关键字
        //而且也不需要显示的用try，catch进行捕捉
        // 一般将范围小的异常放置在前面捕捉，范围大的异常放置在后面捕捉

        val i = 0

        try {
            val s = 10 / i
        } catch {
            case e:ArithmeticException => println("除数为0")
            case ex:Exception => println("其他异常")
        }
    }

}
