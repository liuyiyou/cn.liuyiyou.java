package cn.liuyiyou.java.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/18
 * @version: V1.0
 */
public class SemaphoreExample1 implements Runnable {

    private Semaphore semaphore = new Semaphore(1);

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


}
