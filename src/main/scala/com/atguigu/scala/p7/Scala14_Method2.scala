package com.atguigu.scala.p7

object Scala14_Method2 {
    def main(args: Array[String]): Unit = {

        //集合 - 常用方法
        val list = List(1,2,3,4)
        val list1 = List(1,4,2,3)
        val list2 = List(4,5,6,7)
        val list3 = List(list1,list2)

        //todo 映射 / 转换 ， 将指定的数据转换为其他数据
        //集合的map方法会将集合中的每一个元素执行map方法中传递的逻辑
        //map方法会将每一个数据转换后的结构放置在新的集合中返回
        def transform(i:Int):Int = {
            i * 2
        }
        //返回值的类型可以按照需求时自定义
        def transform2(i:Int):String ={
            "num = " + i
        }
        // map(f:Int => B)，参数为 f: Int => NotInferedB 一个函数，
        // 函数签名中：后面的B为不确定的返回参数类型，任意类型都可以，所以将上面定义的函数传入
        //函数签名中：传入的参数除了是 Int，还可以是 List[Int]
        println(list.map(transform))
        //使用匿名函数
        //list.map((i:Int) => {i * 2})，简化后如下
        println(list.map(_*2))

        //todo 扁平化： 将一个整体数据拆分成一个个的个体来使用，称为扁平化
        println(list3.flatten)
        //将。。
        println(list3.map(list => list.map(_*2)).flatten)
        //或
        println(list3.flatten.map(_*2))

        //todo 扁平映射 ；
        //flatMap等同于将map和flatten融合在一起实现功能
        // 输入参数为集合中的每一个数据
        // 输出的结果为扁平化后的数据集合
        list3.flatMap(list => list.map(_*2))  //可以再简化
        list3.flatMap(_.map(_*2))

        //todo 过滤
        //将集合中的所有数据进行逻辑判断，返回结果为true保留，如果false就舍弃
        list1.filter(num => num % 2 == 0)

        val list4 = List("Spark","Scala","Hadoop")
        println(list4.filter(s => s.startsWith("S")))

        //todo 分组
        // 通过指定的规则进行分组
        //指定逻辑规则的返回值作为分组的key,数据就是分组后的value
        println(list1.groupBy(num => num % 2 ))
        println(list4.groupBy(s => s.substring(0,1)))

        // todo 排序
        //通过制定的逻辑规则进行排序，默认为升序
        println(list1.sortBy(num => num))      //
        //降序
        println(list1.sortBy(num => num)(Ordering.Int.reverse))  //函数的柯里化
        println(list1.sortBy(num => num).reverse)

        val list5 = List("1","2","11","3","22")
        println(list5.sortBy(s => s))  //字典排序
        println(list5.sortBy(s => s.toInt))  //字符串转数字排序


        //自定义对象的排序
/*        val stu1 = new Student()
        stu1.id = 1;
        val stu2 = new Student()
        stu2.id = 2;

        val list6 = List(stu1,stu2)
        println(list6.sortBy(stu => stu.id))*/

        val stu1 = new Student()
        stu1.id = 1;
        stu1.name = "zhangsan"
        val stu2 = new Student()
        stu2.id = 1;
        stu2.name = "lisi"

        //
        val list6 = List(stu1,stu2)
        //println( list6.sortBy(stu=>stu.id + stu.name))
        // 元组可以进行比较,先比较第一个,再比较第二个,依次类推
        // println( list6.sortBy(stu=>(stu.id ,stu.name)) )

        //上面默认 升序，现在需要自定义降序。甚至扩展为自定义升、降序
        println("-------------------------")
        val stu_sort: List[Student] = list6.sortWith((left, right) => {
            if (left.id > right.id) {
                true
            } else if (left.id == right.id) {
                left.name > right.name
            } else {
                false
            }
        })
        println(stu_sort)



    }

}

class Student{
    var id : Int = _
    var name: String = _

    override def toString: String = {
        "user id:" + id + " name:" + name
    }
}
