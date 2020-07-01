package com.atguigu.scala.p7

object Scala15_WordCount {
    def main(args: Array[String]): Unit = {

        //todo WordCount
        val list = List(
            "Hello World",
            "Hello Scala World",
            "Hello Scala",
            "Hello Scala Hadoop" )
        //需求：获取单词出现次数排名前三

/*//        复习时自己写的方式
        val strs: List[String] = list.flatMap(_.split(" "))

        val wordAndCount: Map[String, Int] = strs.map(str => (str, 1)).groupBy(_._1).map(kv => (kv._1, kv._2.length))

        val res: List[(String, Int)] = wordAndCount.toList.sortBy(_._2).takeRight(3)

        println(res)*/




        //todo 1、将原始的字符串拆分成一个个单词
        val wordList: List[String] = list.flatMap(s => s.split(" "))
        println(wordList)
        //List(Hello, World, Hello, Scala, World, Hello, Scala, Hello, Scala, Hadoop)

/*
        //todo 理解：
        //注意理解在flatmap的课堂案例中，list3.flatMap(_.map(_*2))再调用map，而这里不需再调map的原因是：
        //先将原始的元素map处理后放在多个list中，之后再flat扁平。。。。好像理解还是有问题，放在之后再理解吧
        //如果只是map，那么每个String 处理后都会产生一个数组，并组成一个数组为元素的集合
        val stringses: List[Array[String]] = list.map(s =>s.split(" "))
        //所以还要第二部将每一个数组扁平
        val flatten: List[String] = stringses.flatten
        println(flatten)


        //todo 2、将相同的单词放置在一个组中
        val wordToList: Map[String, List[String]] = wordList.groupBy(word => word)
        println(wordToList)
//Map(Hadoop -> List(Hadoop), Hello -> List(Hello, Hello, Hello, Hello), Scala -> List(Scala, Scala, Scala), World -> List(World, World))

        // TODO 3. 将分组后的数据进行结构的转换 (word, list) => (word, list.size)
        val wordToCountMap: Map[String, Int] = wordToList.map(kv => {
            (kv._1, kv._2.size)
        })
        println(wordToCountMap)
//        Map(Hadoop -> 1, Hello -> 4, Scala -> 3, World -> 2)


        // TODO 4. 将转换结构后的数据进行排序(降序),取前三名
        //  但是Map没有sortWith的方法，所以需要转成List集合来处理
        println(wordToCountMap.toList)
        val wordCountRes: List[(String, Int)] = wordToCountMap.toList.sortWith(
            (left, right) => {
                left._2 > right._2
            }
        ).take(3)

        println(wordCountRes)

        //todo 简洁的方式：   方法链
        // 由于Scala是函数式编程，所以返回的结果可以直接再调用方法
        //使用下划线 _ 来简化的话，需要注意必须是能被推断出来才可以
        //如使用递归的时候，返回值就必须显示声明类型
//        list.flatMap(_.split(" ")).groupBy(_)
        //groupBy(_)括号内既可以传函数，又可以传参数，而下划线可以代表函数又可以是参数，所以不能推断
        //todo 原则：当函数给定什么值就返回什么值的场合，参数不能使用下划线代替，会出现错误。
        // 所以 groupBy(_)有误，必须写成groupBy(x=>x)
        println(list.flatMap(_.split(" ")).groupBy(x => x).map(kv => {(kv._1,kv._2.size)}).toList.sortWith(_._2 > _._2).take(3))
        //todo map(kv => {(kv._1,kv._2.size)}这里不能省，因为kv在逻辑中使用了2次，
        // 老师的笔记在map的这部分有误！
        //println(_)之所以可以写，因为里面只能传参数，不能传函数，只有一种情况，可推断，不会有歧义。



*/







    }

}


