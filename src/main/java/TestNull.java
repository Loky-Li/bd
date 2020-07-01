import java.util.List;

public class TestNull {
    public static void main(String[] args) {

        //当调用一个空对象的成员属性和成员方法时，出现空指针异常
/*        UserK user = null;
        System.out.println(user.name);*/

/*

        //todo 下面的空指针异常很难找，打破了以前对空指针的认知
        //以往的思路会从user对象是否为空去寻找问题的根源，但下面不是
        UserK user = new UserK();
        test(user.id);
        // todo 解析上面出现空指针异常的原因：
        //字节码中：出现了 Method java/lang/Integer.intValue:()I
        // 因为user.id 是一个Integer而，test()方法的参数定义的是int类型
        //拆箱：Integer.intValue
        //装箱：Integer.valueOf(int)
        //而user.id 为 Integer类型，值为null，调用intValue方法时，
        // 就符合了出现空指针异常的条件：空对象调用了它的成员方法。
*/

        //同样的集合中，也有这样不明显的空指针异常问题：
        List<String> list = null;
        for (String s : list){
            System.out.println(s);
        }
        //同样底层的字节码中可以看到，增加for循环实际上是使用集合的迭代器：
        // List.iterator:()  ，也还是List对象调用它的成员方法，而List为null，所以为空指针异常

    }

    public static void test(int id){
        System.out.println("打印主键 = " + id);
    }
}

class UserK{
//    public static String name = "zhangsan";
    //上面UserK的对象user.name 不会报空指针异常，因为静态的属性和方法，类加载时加载，和对象无关

    public String name = "zhangsan";
    public Integer id = null;
}
