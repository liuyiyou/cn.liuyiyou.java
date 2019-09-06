package cn.liuyiyou.java.thread.type;

/**
 * @author: liuyiyou.cn
 * @date: 2019/9/5
 * @version: V1.0
 */
public class NewThreadByImplRunable implements Runnable {

    public static void main(String[] args) {
        new Thread(new NewThreadByImplRunable()).start();
    }

    @Override
    public void run() {
        System.out.println("run");
    }
}
