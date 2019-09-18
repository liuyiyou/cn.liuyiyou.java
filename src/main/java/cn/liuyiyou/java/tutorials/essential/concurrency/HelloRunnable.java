package cn.liuyiyou.java.tutorials.essential.concurrency;

/**
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
 * @author: liuyiyou.cn
 * @date: 2019/9/17
 * @version: V1.0
 */
public class HelloRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello from a thread");
    }

    public static void main(String[] args) {
        new Thread(new HelloRunnable()).start();
    }
}
