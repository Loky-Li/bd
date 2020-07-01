import java.util.ArrayList;

public class TestGeneric {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add(new EmpTest());

/*        //泛型不可变，没有子父类的关系，右边的泛型中加入ChildTest会报错
        ArrayList<UserTest> userList = new ArrayList<>();
        //而在放对象时，可以放入子类对象，因为子类对象可以代替父类对象
        userList.add(new UserTest());
//        userList.add(new PatentTest());  //报错
        userList.add(new ChildTest());*/

        //泛型无法对声明之前的数据类型做约束
        //只能对声明之后的操作进行类型约束。所以下面的操作不会报错，且打印也不报错
        ArrayList<UserTest> userList = list;

        System.out.println(userList);
        //泛型一般在进行类型操作的时候会出错，如果不进行类型操作，那么就不会出问题
        //>.

    }
}

class PatentTest{

}

class UserTest extends PatentTest{

}

class ChildTest extends UserTest{

}

class EmpTest{

}
