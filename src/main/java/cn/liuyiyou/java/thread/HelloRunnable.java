package cn.liuyiyou.java.thread;

/**
 * @author: liuyiyou@yanglaoban.com
 * @date: 2018/10/22
 * @version: V1.0
 * @Copyright: 2018 yanglaoban.com Inc. All rights reserved.
 */
public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello from a thread!");
    }

    public static void main(String args[]) {
        (new Thread(new HelloRunnable())).start();
    }
}
