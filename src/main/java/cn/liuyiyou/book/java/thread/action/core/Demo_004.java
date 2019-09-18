package cn.liuyiyou.book.java.thread.action.core;

/**
 * @author: liuyiyou.cn
 * @date: 2019/9/17
 * @version: V1.0
 */
public class Demo_004 implements Runnable {

    public static void main(String[] args) {
        Runnable runnable = new Demo_004();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("运行结束");
    }

    @Override
    public void run() {
        System.out.println("运行中");
    }
}
