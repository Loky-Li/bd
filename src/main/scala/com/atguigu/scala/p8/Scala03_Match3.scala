package com.atguigu.scala.p8

object Scala03_Match3 {

    //todo 模式匹配 - match - 匹配数组
    def main(args: Array[String]): Unit = {

        for (arr <- Array(
            Array(0),
            Array(1, 0),
            Array(0, 1, 0),
            Array(1, 1, 0),
            Array(1, 1, 0, 1),
            Array("hello", 90))) { // 对二维数组中的一个个一维数组进行遍历

            val result = arr match {
                case Array(0) => "0" //匹配Array(0) 这个数组

                case Array(x, y) => x + "," + y //匹配有两个元素的数组，然后将将元素值赋给对应的x,y

                case Array(0, _*) => "以0开头的数组" //匹配以0开头和数组

                case _ => "something else"
                //对比上一个对类型匹配的例子，这里可以使用下划线，
                // 因为式子前面没有赋值给下划线，而后面的输出没有使用到下划线
            }

            println("result = " + result)
        }

        //注意，商密上面的 for结构其实就是下面简单的for结构，
        // 不要因为加上了匹配的逻辑就认不得了。
        for(i <- 1 to 5){
            //  对遍历的每一个元素就行逻辑操作
            println(i)
        }
    }










}
