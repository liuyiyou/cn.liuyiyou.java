package cn.liuyiyou.java.thread.type;

/**
 * @author: liuyiyou.cn
 * @date: 2019/9/5
 * @version: V1.0
 */
public class NewThreadByExtendThread extends Thread {

    public static void main(String[] args) {
        new NewThreadByExtendThread().start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run");
    }
}
