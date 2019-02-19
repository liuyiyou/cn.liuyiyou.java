package cn.liuyiyou.java.concurrent;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/18
 * @version: V1.0
 */
public class RunSemaphoreExample1 {


    public static void main(String[] args) {
        SemaphoreExample1 semaphoreExample1 = new SemaphoreExample1();
        Thread a = new Thread(semaphoreExample1, "ThreadA");
        Thread b = new Thread(semaphoreExample1, "ThreadB");

        a.start();
        b.start();

    }
}
