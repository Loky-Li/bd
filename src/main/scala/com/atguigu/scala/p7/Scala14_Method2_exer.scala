package com.atguigu.scala.p7

object Scala14_Method2_exer {
    def main(args: Array[String]): Unit = {

        //集合 - 常用方法
        val list = List(1,2,3,4)
        val list1 = List(1,4,2,3)
        val list2 = List(4,5,6,7)
        val list3 = List(list1,list2)

        println("-------map ： 映射----------")
        //todo 映射 / 转换 ， 将指定的数据转换为其他数据
        def transform(i: Int): Int = {
            i * 2
        }

        // map(f:Int => B)，参数为 f: Int => NotInferedB 一个函数，
        // 函数签名中：后面的B为不确定的返回参数类型，任意类型都可以，所以将上面定义的函数传入
        //匿名函数中，传入的参数除了是 基本类型(如本例中的Int)，还可以是集合(本例的List[Int])，见下面的扁平化的应用案例方式一
        println(list.map(transform))
        //使用匿名函数
//        list.map((i:Int) => {i * 2})，简化后如下
        println(list.map(_*2))



        println("-------flatten:扁平化----------")
        //todo 扁平化： 将一个整体数据拆分成一个个的个体来使用，称为扁平化
        //需求：将list3中的2个元素(list类型)，中的每个值 乘2倍 并最终返回一个list集合
        //todo 方式一：将list3的2个集合元素分别映射后再扁平
        //map的参数函数不仅可以是基本数据类型，还可以是集合。那么先传入list集合，在逻辑体内再调用一次map处理
        list3.map(list => list.map(i => i * 2)).flatten
        //简化：
        list3.map(list => list.map(_*2)).flatten
        //再简化：---------卧槽，下面的简化如果直接写，比人还真的一下子看不懂
        list3.map(_.map(_*2)).flatten
        //todo 方式二：先将list3中的两个集合扁平了，再一次map
        println(list3.flatten.map(_*2))         //还是这个方式香，不过方式一是为了练习

        println("--------flatMap : 扁平映射---------")
        //todo 扁平映射 ；
        //flatMap等同于将map和flatten融合在一起实现功能
        // 输入参数为外部集合的元素，即内部集合，然后再map处理内部结合的每个元素
        // 之后将外部集合内的每个内部集合扁平化，得到结果
        list3.flatMap(list => list.map(_*2))  //可以再简化
        println(list3.flatMap(_.map(_*2)))



        println("--------filter : 按条件过滤 ---------")
        //todo 过滤
        //将集合中所有的数据进行逻辑判断,返回结果为true保留,如果为false就舍弃
        list1.filter(num => num%2 == 0)     //简化如下：
        println(list1.filter(_%2 == 0))
        val list4 = List("Spark", "Scala", "Hadoop")
        list4.filter(s => s.startsWith("S"))    //简化如下：
        println(list4.filter(_.startsWith("S")))


        println("--------groupby : 按指定规则分组 ---------")
        //todo 分组
        // 通过指定的规则进行分组
        //指定逻辑规则的返回值作为分组的key,数据就是分组后的value
        list1.groupBy(i => i % 2)  //简化如下：
        println(list1.groupBy(_%2))     //  Map(1 -> List(1, 3), 0 -> List(4, 2))
        println(list4.groupBy(_.substring(0,1)))    //Map(S -> List(Spark, Scala), H -> List(Hadoop))


        println("--------sortBy : 按指定规则排序 ---------")
        // todo 排序
        //通过制定的逻辑规则进行排序，默认为升序
        list1.sortBy(num => num)      //简化后如下：
//        println(list1.sortBy(_))      这样并不能简化，编译器无法理解
        println(list1.sortBy(num => num))
        //降序
        println(list1.sortBy(num => num)(Ordering.Int.reverse))
        //降序：或
        println(list1.sortBy(num => num).reverse)

        //需求：按照字符串本身来排序：
        val list5 = List("1","2","11","3","22")
        println(list5.sortBy(s => s))       //字典排序
        //不使用字典排序：将字符串转数字排序
        println(list5.sortBy(s => s.toInt))



        println("--------sortBy-② : 按指定规则 对自定义对象 排序 ---------")
        //自定义对象的排序
/*        val stu1 = new Student()
        stu1.id = 1;
        val stu2 = new Student()
        stu2.id = 2;

        val list6 = List(stu1,stu2)
        println(list6.sortBy(stu => stu.id))*/

        val stu1 = new Student2()
        stu1.id = 1;
        stu1.name = "zhangsan"
        val stu2 = new Student2()
        stu2.id = 1;
        stu2.name = "lisi"

        //
        val list6 = List(stu1,stu2)
        //println( list6.sortBy(stu=>stu.id + stu.name))
        // 元组可以进行比较,先比较第一个,再比较第二个,依次类推
        // println( list6.sortBy(stu=>(stu.id ,stu.name)) )


        println("--------sortWith: 按指定规则 对自定义对象 来自定义排序 ---------")
        //上面默认 升序，现在需要自定义降序。甚至扩展为自定义升、降序
        println("-------------------------")
        val stu_sort: List[Student2] = list6.sortWith((left, right) => {
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

class Student2{
    var id : Int = _
    var name: String = _

    override def toString: String = {
        "user id:" + id + " name:" + name
    }
}
