package com.atguigu.scala.p4

object Scala02_Logic_for {
    def main(args: Array[String]): Unit = {
        //Todo 逻辑 - 循环 - for

        //1 to 3 是一个 Range:  集合,
        //而如果能够推断出数据的类型，那么变量的类型可以省略
       for(i:Int <- 1 to 3){
            println(i)
       }

        println("----------------------------")
        //1 to 3 表示1/2/3 ， 1 until 3 表示的是 1、2
        //步长的话使用的是 by
        for(i <- 1 to 5 by 2){
            println(i)
        }

        println("-------------Range实现步长---------------")
        //使用集合Range来实现步长，但是注意是不包括最后的一个值，是until的效果
        val list = new Range(1,5,2)
        for(i <- list){
            println(i)   //不会打印5
        }

        println("----------------------------")
        //嵌套循环：不提倡使用，不清晰，而且没有嵌套在里面灵活。
        // 因为2个for的话，每层循环内还可以定义一些处理逻辑
        for(i <- 1 to 3; j <- 1 to 3){

        }

/*
        println("----------------------------")
        //for循环本身也有结果
        val result = for(i <- list){
            i * 2
        }
        println(i)     //返回 （）  则说明没有值

        //需求：将原数据中所有值乘以2，并把数据返回到一个新的集合中。
        //通过使用 yield 实现了（了解即可，很少用）
        var res = for(i <- 1 to 10) yield 2*i
        println(i)
*/
        println("----------------")
        for(i <- 1 to 4  if i !=2){
            println(i)
        }

        //倒序打印
        println("----------------")
        for(i <- 1 to 3 reverse){
            println(i)
        }

        println("----------------")
        for(i <- 1 to 9 by 2){
            println(i)
        }

        val ints = List(1,2,3,4)
        //使用yield的方式
        val intsTransform2: List[Int] = for(i <- ints) yield {
            i * 2
        }
        println(intsTransform2)

        //使用map的方式（后面学的）
        val intsTransform: List[Int] = ints.map(_*2)
        println(intsTransform)




    }

}
