package cn.liuyiyou.java.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: liuyiyou.cn
 * @date: 2019/3/7
 * @version: V1.0
 */
public class ReetrantLockForIncreaseRight {

    //初始化ReetrantLock
    public static ReentrantLock reetrantLock = new ReentrantLock();
    static int cnt = 0;

    public static void main(String[] args) {
        Runnable r = () -> {
            //加锁
            System.out.println(Thread.currentThread().getName() + "::" + cnt);
            reetrantLock.lock();
            System.out.println(Thread.currentThread().getName() + "::" + cnt);
            int n = 10000;
            while (n > 0) {
                cnt++;
                n--;
            }
            //执行完毕后释放锁
            reetrantLock.unlock();
        };
        Thread t1 = new Thread(r, "Thread1");
        Thread t2 = new Thread(r, "Thread2");
        Thread t3 = new Thread(r, "Thread3");
        Thread t4 = new Thread(r, "Thread4");
        Thread t5 = new Thread(r, "Thread5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            //等待足够长的时间 确保上述线程均执行完毕
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cnt);
    }


}
