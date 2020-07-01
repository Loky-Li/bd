package com.atguigu.scala.p6

object Scala24_Object_Ext {
    def main(args: Array[String]): Unit = {
       //实现重要类的id属性相等，那么就讲个对象就认为相等
        //在Java中重写equal方法即可实现（自己尝试写: 见Java包中的 TestEp类）
        //Scala 中是面向对象，所以 instanceof 和 强制类型转换都不是面向对象
        //（复习）Scala没有强制类型装换，都是使用方法，如 toInt()等

        var user = new User24()
        var user2 = new User24()
        println(user.equals(user2))

        // 获取类的信息 classOf()方法是 Predef._所以可以直接用
        val c: Class[User24] = classOf[User24]
        

    }
}

class User24{
    var id: Int = _

    override def equals(obj: Any): Boolean = {

        // Scala语言中使用[ ]中括号表示泛型

        // isInstanceOf 判断是否为指定类型的实例
        if(obj.isInstanceOf[User24]){

            // asInstanceOf 将对象转换为指定类型的实例
            val other = obj.asInstanceOf[User24]
            return this.id == other.id
        }else{
            false
        }
    }


}
