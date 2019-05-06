package cn.liuyiyou.java.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/18
 * @version: V1.0
 */
public class SemaphoreExample1 implements Runnable {

    //同一时间内，最多允许一个线程执行 accquire到release的方法
    private Semaphore semaphore = new Semaphore(2);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + ",begin timer: " + System.currentTimeMillis());
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ",end timer: " + System.currentTimeMillis());
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * new Semaphore(1);
     * A,begin timer: 1552027837709
     * A,end timer: 1552027838709
     * B,begin timer: 1552027838709
     * B,end timer: 1552027839709
     * <p>
     * <p>
     * new Semaphore(2);
     * A,begin timer: 1552027868908
     * B,begin timer: 1552027868910
     * A,end timer: 1552027869910
     * B,end timer: 1552027869911
     *
     * @param args
     */
    public static void main(String[] args) {
        SemaphoreExample1 semaphoreExample1 = new SemaphoreExample1();
        Thread a = new Thread(semaphoreExample1, "A");
        Thread b = new Thread(semaphoreExample1, "B");
        Thread c = new Thread(semaphoreExample1, "C");
        a.start();
        b.start();
        c.start();
    }


}
