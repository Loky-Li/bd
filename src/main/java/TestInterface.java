public class TestInterface {
    public static void main(String[] args) {
        //----①
        G g = new I();

        //通过获取I类的接口的长度来判断I 是否实现了接口。
        //打印的结果是0，所以 I 没有实现G接口。
        //上面①的代码没有报酬是因为，它完整应该是 G g = new H(); H h = new I(); 多态的传递
        System.out.println(I.class.getInterfaces().length);
    }
}

interface G{}

class H implements G{}

class I extends H{

}
