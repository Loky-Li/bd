package com.atguigu.scala.p7

object Scala10_Tuple {
    def main(args: Array[String]): Unit = {
        //将数据封装
        // username : zhangsan, age : 20, email:xxxx
        // username : lisi, age : 30, email:yyyy
        val user = new User100();
        user.username = "zhangsan"
        user.age = 20
        user.email = "xxxxx"

        //封装：1,2,3,4,5,6
        val idList = List(1,2,3,4,5,6)

        //封装：Loky,520,雨宣,Xenia,1314,xxx..
        //Tuple: 元组 => 无关数据元素的组合
        val tuple: (Any, Int, Any, Any, Int, Any) = ("Loky",520,"雨宣","Xenia",1314,"xxx")
        // 元组数据需要通过顺序号来访问其中的数据
        // Scala元组中的元素数量最多只能放22个
        println("---------通过顺序号访问----------")
        println(tuple._3)   //todo 注意是顺序号，不是索引

        //Scala中的Tuple最多能放22个元素

        println("------通过迭代器来遍历访问...-------")
        for(elem <- tuple.productIterator){
            println(elem)
        }

        println("------通过索引来单个元素访问...------")
        println(tuple.productElement(0))


    }

}

class User100{
    var username: String = _
    var age : Int = _
    var email : String = _
}
