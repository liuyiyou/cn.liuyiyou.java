package cn.liuyiyou.java.tutorials.essential.concurrency;

/**
 * @author: liuyiyou.cn
 * @date: 2019/9/17
 * @version: V1.0
 */
public class HelloThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from a Thread");
    }

    public static void main(String[] args) {
        new HelloThread().start();
    }
}
