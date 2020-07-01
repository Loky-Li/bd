public class TestOverwrite {
    public static void main(String[] args) {

        //①：下面情况打印20
        //E e = new E();

        //②：对象改为是 F ，下面情况打印40
        //E e = new F();

        //③：在②基础上，同时将 F类 中的getSum()方法注掉后，打印的是20
        //解析：虽然对象是 F 类的，但是调用的是 E类的getSum()方法，当
        //      所以 使用的 i 也是 E 类的
        E e = new F();

        System.out.println(e.getSum());

        //方法的重写：父类和子类具有相同的方法，不知道调用哪一个，JVM遵循动态绑定机制
        //动态绑定机制：在调用对象的成员时，会查看对象的实际内存是什么，
        // 将成员方法和实际内存进行绑定，然后调用。

        //情况 ④：

        //属性相关：注释掉开始的 E 类 和 F 类，验证动态绑定调用
        //注意：属性没有动态绑定机制，在哪里声明就调用哪里的。
        //      子类会包含父类中的同名属性，子类会省略this. ，要使用父类的话使用 super.
        //

    }
}
/*

情况①②③

class E{
    public int i = 10;
    public  int getSum(){
        return i + 10;
    }
}

class F extends E{
    public int i = 20;
//    public  int getSum(){
//        return i + 20;
//    }
}
*/

//情况④，代码改成下面后，结果解析：      E e = new F();      求 e.getSum()
//e 属于 F类对象，但是没有getSum()方法，使用的是E类的getSum()
//而getSum()里面的 getI()方法属于成员方法，由于动态绑定机制，F 类中有，所以使用的是F 类的getI()
// 而 getI() 在 F 类里面，所以方法中的 i 属性使用的是 F 类中的 i （类似情况③ 选择i 的原理）
// 最后 i = 20 使用 E 的 getSum()方法，即只加 10， 结果为 30
class E{
    public int i = 10;
    public  int getSum(){
        return getI() + 10;
    }
    public  int getI(){
        return  i;
    }
}

class F extends E{
    public int i = 20;
//    public  int getSum(){
//        return getI() + 20;
//    }

    public  int getI(){
        return  i;
    }
}
