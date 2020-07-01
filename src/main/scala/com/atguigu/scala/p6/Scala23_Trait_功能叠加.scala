package com.atguigu.scala.p6

object Scala23_Trait {
    def main(args: Array[String]): Unit = {
        //todo 特质的功能叠加: MySql 类 混入的特质File和Memory都有operData()的方法
        // Java中不能多继承的原因：c继承a、b，而a、b又继承d，那么a、b可能都重写了d的test方法，（文档中的砖石结构）
        // 造成c无法判断使用a、b中哪个重写的方法

        //todo Scala中可以实现功能叠加
        // 多个特质的初始化顺序为从左到右
        // 多个特质的方法执行顺序从右到左
        //todo：super在trait中的含义：不是上一级的trait，而是上一个trait
        //上面的执行顺序可以通过初始化时包装顺序来理解（见老师画的图，一下子就明白）
        // 即一层层向外包装，然后外界执行读取时，先看到的是最外层是trait

//        todo super的含义是上一个trait
        //todo 如果想跳过上一个trait，直接到某个层的方法，通过 super[oper].oper..指定跳到某一层
        val mysql = new MySQL()
        mysql.operData()    // 向文件中向内存中操作数据......

    }
}
trait Operate {
    def operData(): Unit = {
        println("操作数据......")
    }
}
trait Memory extends Operate {
    override def operData(): Unit = {
        print("向内存中")
        super.operData()
    }
}
trait File extends Operate {
    override def operData(): Unit = {
        print("向文件中")
        super.operData()

        //直接跳到Operator层的方法（也就是跨过了Memory层）
//        super[Operate].operData()
    }
}
//从左到右，初始化Memory，而Memory继承自Operator，所以最先初始化Operator，再初始化Memory，最后初始化File
// File => Memory => Operate
//外界最新调用到的trait是：File，整体顺序为·File => Memory => Operate
class MySQL extends Memory with File {

}