public class TestString1_Thread {

//    static StringBuilder buff = new StringBuilder();

    //多线程可以多次调用main方法
    public static void main(String[] args) {


        // todo 理解可变不可变
        //可变字符串：StringBuffer，StringBuilder
        //StringBuffer线程安全，因为它的底层都加了关键字synchronized
        String s = "";

        //使用StringBuilder而不用StringBuffer的原因是因为main方法时多线程调用
        //每次都new一个对象，多例，所以选用StringBuffer和StringBuilder，都不存在线程安全问题
        //所以选择效率更高的StringBuilder
        StringBuffer buff = new StringBuffer();
        for (int i = 0; i < 1000000000L; i++){
            s = s + i;
            buff.append(i);
        }


        //todo   出现线程不安全的问题原因：
        //线程安全
        // 所谓的线程安全问题，其实多线程并发执行时，对共享内存中的共享对象的属性进行修改时
        // 所导致的数据冲突问题

        //todo 下面是发生线程安全的原因及解决方案
        //多线程 ： 单线程
        // 共享内存 ：多线程共享的内存 ：堆内存，方法区内存
        //          :将对象放置在独享内存中（栈上分配，逃逸分析）
        // 共享对象 ：多线程访问的是同一个对象 ： Servlet
        //          ： 多例，每一个线程使用一个对象 : Struts2 => SSH =>
        // 属性 : 对象属性只有一个，（而多个线程调用同一个对象的同一方法时，不会出现线程安全，因为每次调用方法都会压栈）
        // 修改 ： 多线程同时修改

        // 线程安全举例：请给出下面多线程的执行结果！
        final Dept2 dept = new Dept2();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                dept.name = "开发部";

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(dept.name);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                dept.name = "测试部";

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(dept.name);
            }
        });

        System.out.println("mian方法执行完毕");
        t1.start();
        t2.start();

        //预想结果：
        // main方法执行完毕
        // 开发部（测试部）
        // 测试部（开发部）

        //实际结果
        // main方法执行完毕
        // 开发部（测试部）
        // 开发部（测试部）

        //原因：两个线程对同一个属性进行操作（见老师上课画的分析图特别清晰）


    }
}

class Dept2{

    public String name = "";
}
