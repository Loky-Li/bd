package com.atguigu.scala.p6

object Scala14_Abstract {
    def main(args: Array[String]): Unit = {
        //todo 面向对象  - 抽象类 - 抽象属性

        println(new User14().age)

        // todo 匿名子类（和Java的抽象类的匿名对象一样原理）
        new Parent14 {
            override var age: Int = _
        }

        //todo 多态
        val person : Parent14 = new User14();
        //注意：Scala中由于存在类型推断，如果使用下面的写法，直接将类型确定为User14了，
        // 并没有实现多态的目的，所以Scala中使用多态时，必须显示地声明类型。
        // val person = new User14();


    }
}

abstract class  Parent14(){

    //完整的属性
//    var name: String = "雨宣"
    val name: String = "雨宣"

    //抽象属性：只有声明，没有初始化，而且所在的类必须是抽象类
    //编译时，没有生成私有属性，而是生成属性对应的set/get方法，但都是抽象的
    //所以所谓的抽象属性，在底层Java中，还是抽象方法。
    var age : Int

    def test():Unit = {
       // name = "wangwu"
        println(name)
    }

    //todo Scala属性动态绑定的理解：
    //--假设重写的变量可变，那么在调用test方法时，根据Scala中属性也遵循动态绑定机制的原则
    //todo Scala属性也动态绑定的原因还是由于Java中成员方法动态绑定：
    //todo 本质是Scala属性的get/set方法动态绑定，那么调用对应的属性时，底层就调用对应类属性的get/set方法！
    //声明的类对象时子类User14，方法test是父类的，但是方法内的name由于在子类中存在，所以使用的是子类的name
    //而修改值，调用的set方法时成员方法，所以也是调用子类的set方法。动态绑定，修改的是子类的值
    //最后修改后，打印的也是修改的name。但是在父类中的test代码语义应该是对父类的name进行修改，但最终改的是子类的name
    //和初衷违背，但是打印显示的现象看起来是对的。这样会造成歧义。
    //但是当将这个需要被重写的变量声明为val后，就杜绝了这种歧义的操作出现，因为直接报错。
    // （我感觉我理解了，但是文字表达还是有些吃力。可以再看视频44，11：00之后 的内容）
    //注意：父类声明val不是代表子类不可以修改这个变量...子类是重写了一个变量，表示的是
}
class User14 extends Parent14{

    //重写完整的属性：只要是重写父类的完整内容（方法或属性），都必须加上override关键字
    //可变的变量不能被重写，父类中被重写的属性必须是使用val声明，原因是:—写在父类的test方法
    //
//    override var name = "Xenia"
    override val name = "Xenia"

    //将抽象的属性补充完整
    //原理：在编译后可以看到，表面是age属性继承自父类，而实际上是子类重新声明了一个age属性，同提供age的get/set方法
    //而父类中age的get/set是抽象方法，在子类重新生成age属性并提供了实际get/set方法，就通过这种奇怪的方式等同于重写父类抽象方法的规则。
    var age : Int = 25


}



