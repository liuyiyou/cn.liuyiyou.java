package cn.liuyiyou.book.java.juc.in.action.ch03;

/**
 * 清单3.1（在没用同步的情况下共享变量）
 * @author: liuyiyou.cn
 * @date: 2019/9/17
 * @version: V1.0
 */
public class NoVisiblity {
    //被共享的实例域
    private static boolean ready;
    private static int number;

    //主线程
    public static void main(String[] args) throws InterruptedException {
        new ReadyThread().start();
        Thread.sleep(1000L);
        number = 42;
        ready = true;
    }

    //另一个线程
    private static class ReadyThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

}
