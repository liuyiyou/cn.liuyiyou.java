package cn.liuyiyou.book.java.thread.action.core;

/**
 * @author: liuyiyou.cn
 * @date: 2019/9/17
 * @version: V1.0
 */
public class Demo_002 extends Thread {

    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }

    public static void main(String[] args) {
        Demo_002 demo_002 = new Demo_002();
        demo_002.start();
        System.out.println("运行结束");
    }
}
