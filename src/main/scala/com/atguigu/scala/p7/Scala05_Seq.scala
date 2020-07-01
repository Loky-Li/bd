package com.atguigu.scala.p7

object Scala05_Seq{
    def main(args: Array[String]): Unit = {
        // 集合 - Seq - List
        //创建集合
//        val list: List[Nothing] = new List()  //todo Class 'List' is abstract; cannot be instantiated
        val list: List[Int] = List(1,2,3,4)

        //增加数据
        val list1: List[Int] = 5 +: list   // 完整的话：list.+:(5)
        println(list)
        println(list.eq(list1))
        println(list1)

        //Scala中 List() 表示 Nil，就是一个空集合。
        //Scala中常用的创建集合的方式。 双冒号表示增加元素。
        // todo 后面一定要更Nil，表示创建集合并添加元素否则会报错.(只能写在后面)
        val list2 = 1::2::3::Nil
        println("list2的长度为： " + list2.length)

        val list3 = 4::list2::Nil  //这种情况将list2当成一个整体，作为元素放入list3，list3的长度是2
        println("list3的长度为： " + list3.length)       //---2
        println(list3)

        //当不想把集合当成一个整体，而是将集合的所有元素作为个体添加
        //todo 术语：扁平化操作。  在最后添加空集合时，使用三个冒号， :::Nil
        val list4 = 1::5::list2:::Nil
        println(list4)
        println("list4的长度是： " + list4.length)

        println("----------------------------")
        //todo 扁平化的方式二:   .++: 可以添加集合的所有元素
        val list5: List[Int] = list.++:(list1)
        println("list: " + list)
        println("list1: " + list1)
        println("list5: " + list5)

        println(" .++:  转为 ++： ")
        val list55: List[Int] = list1 ++: list
        println("list55: " + list55)

        println("----------------------------")
        //todo ：  .++:   和 .+:  的区别， .+: 后面添加的内容被当成一个元素,添加的位置放在原数据的前面
        val list6: List[Any] = list.+:(list1)   // 等同于 list1 +: list
        println("list: " + list)
        println("list1: " + list1)
        println("list6: " + list6)



        //修改
        //list(0) = 5 // error ，只有在可变集合中 list(0)=5 才等价于 list.updated(0,5)
        //同时会产生一个新的List集合
        val ints: List[Int] = list.updated(0,5)
        println(ints)


        println("----------------------------")


    }
}
