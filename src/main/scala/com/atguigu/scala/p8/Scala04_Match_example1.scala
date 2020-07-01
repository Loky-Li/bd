package com.atguigu.scala.p8

object Scala04_Match_example1 {

    //todo 模式匹配 - match - 匹配的至简原则
    def main(args: Array[String]): Unit = {

        //求下面用户年龄的平均值
        val list = List((1,"Xenia",25),(2,"Loky",26))
        val list2 = List((1,"Xenia",25))
        //使用map，顺序号来表示数据，如下面的 tp._3，在代码里不是很直观。
        // 后期再看代码，第一时间不能知道是什么意思。而且实际的代码不是只有几行，
        // 那么要理解 tp._3 可能就得翻看很长的代码后才能理解。
        val ageList: List[Int] = list.map(tp => tp._3)
        val avgAge: Double = (ageList.sum.toDouble / ageList.size)
        println(avgAge)


        //todo 模式匹配也可以使用至简原则：省略 match 和 case
        // 如下面是一个元素匹配
        val (id,name,age) = (1,"Xenia",25)
        println(age)

        //todo 同样的使用之前的wordCount案例来感受 匹配的至简原则。
        // 循环多个元素
        val wordCountTupleList = List(("Loky",5),("love",2),("Xenia",0))
        //原来的方式 ：很不直观
        for(t <- wordCountTupleList){
            println(t._1 + "=" + t._2)
        }
        //todo 而使用模式匹配后，太舒服了，见名知意。
        for((word,count) <- wordCountTupleList){
            println(word + "=" + count)
        }

        //todo 如果只是关心某些字段，并且逻辑中也只使用这些字段，那么其他字段直接使用下划线代替
        // 回到开始的案例，求平均年龄。将没必要的字段不显示。

        val list3 = List((1,"Xenia",25),(1,"雨宣",19),(2,"Loky",26),(2,"敦宏",20),(3,"宏宣",28))
        var ageSum = 0.0
        for((_,_,age) <- list3){
            ageSum += age
        }
        val avgAge2: Double = ageSum/list3.size
        println("使用模式匹配后求平均年龄：" + avgAge2)

        //todo 模式匹配不经可以将，还可以实现过滤！将需要过滤留下的值直接放在匹配的规则基准值中。
        // 这里的规则基准值是自己命名的，如(_,_,age)，表示实际值拿来和这个值匹配，看是否匹配上。
        //如下面过滤留下 id = 1 的数据
        var agePartSum =0.0
        for((1,_,age) <- list3){
            agePartSum += age
        }
        println(agePartSum)

        //但是如果想过滤某个范围的值呢？比如id < 3 的信息留下呢？（老师上课没有讲，试一下）
        //并不能直接放在匹配的规则基准值中，而是在逻辑体里面再判断。不过也很直观，比使用filter要方便
        var agePartSum2 = 0.0
        for((i,_,age) <- list3){
            if(i < 3)
            agePartSum2 += age
        }
        println(agePartSum2)

        //todo 课件中的 8.5 给出了 直接在匹配规则基准值中，按照条件过滤，格式如下：
        var agePartSum3 = 0.0
        for((id,_,age) <- list3 if id < 3){
           agePartSum3 += age
        }
        println(agePartSum3)






    }

}
