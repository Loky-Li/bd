public class TestFinally {
    public static void main(String[] args) {

        //todo ： try-finally 中都有return时的返回值解析
        //todo ： 异常的其他常用场景：如获取当前类名

        System.out.println(test());

    }

    public static int test() {
        int i = 0;

        //todo 要点：
        // i++ 和 ++i 都会产生一个临时变量。 _tmp
        // 每个return ，也会产生一个 临时变量 _rtnVal，这就是return返回的值
        // 当try和finally中都存在return时，try中的return并不会立刻执行，而是继续走到finally，最后finally中执行return
        //所以最终下面的try-catch 的执行顺序如下：

        try {
            //return i++;      // 1) _tmp = 0; i = 1； 2）_rtnVal = _tmp; 3) return _rtnVal

            //测试获取当前TestFinally类的类名：
            //通过手动抛异常后，打印出的异常的堆栈信息，就包含有当前类的类的类名
            new XX().test();
            return i;

        } finally {
            //return ++i;      // 4) _tmp1 = 2; i = 2；5) _rtnVal = _tmp1; 6) return _rtnVal
            // (todo 上下的_rntVal是同一个变量，所以注释掉上面一行，执行下一行的返回结果是 try中的 _rtnVal,即0)
            ++i;    // 0
        }

    }

}

class XX {

    public void test() {

        //手动抛出异常，并打印异常的堆栈信息
        //从堆栈信息中，打印调用了该方法的类信息
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement ste : stackTrace) {
                //找到main方法
                if (ste.getMethodName().equals("main")) {
                    //获取main方法所在的类
                    System.out.println(ste.getClassName());
                }

            }
        }

    }

}
