package com.atguigu.scala.p8

object Scala08_Match_Partial {
    def main(args: Array[String]): Unit = {

        //todo - 匹配 - 偏函数
        //偏函数：函数只对满足条件的数据进行操作，并不会对所有的数据进行操作

        val list = List(1,2,3,4,5,6,"test")

        //需求：将该List(1,2,3,4,5,6,"test")中的Int类型的元素加一，并去掉字符串

        //val list1 = list.map(_+1)  //报错，虽然数字能加1，字符串加1也还是字符串
        //todo 报错的原因是 List的类型，根据通用性原则，它的类型应该是 Any，而Any类型没有 + 运算

        //所以先过滤掉字符串
        val list2: List[Any] = list.filter(data => data.isInstanceOf[Int])
        //但是List的类型还是Any，所以需要将类型再转换为Int
        val list3: List[Int] = list2.map(data => {
            data.asInstanceOf[Int] + 1
        })
        println(list3)

        //todo 但是上面的方式和需求的顺序不一致，
        //使用map，普通的方式。
        println(list.map(data => {
            if (data.isInstanceOf[Int])
                //data + 1 为什么会报错呢？？（原理其实就是上面方式一的写法了）
            // 虽然单个data有时Int，有的是String，但编译器会以为是Any类型
                //即使在If中有判断了，但是要运算的时候，还是要先转转一下类型
            //所以很诡异的是：当单个依次取出来判断类型时，编译器可以知道单个的类型是什么。
            // 但是当单个取出来运算时，它又变回了整体时，List的泛型类型
                //println(data) 可以通过IDEA对data的类型提示来验证if判断是Int后就来的data，仍然是Any类型

                data.asInstanceOf[Int] + 1
            else
                data
        }))     //之后再过滤

        // todo 使用map 模式匹配的方式 (注意map/filter 使用模式匹配的格式，下面和原理不一样)
        println(list.map(data => {
            data match {
                case num: Int => num + 1
                case d => d //不使用下划线的原因是返回值需要使用内容
            }
        }))         //之后再过滤调字符串



        //todo 方式三： 偏函数
        //collect方法可以对部分数据进行采集
        //collect方法支持偏函数，看源码中方法声明为 partialFunction
        val ints: List[Int] = list.collect {
            case num: Int => num + 1
        }
        println(ints)





    }

}
