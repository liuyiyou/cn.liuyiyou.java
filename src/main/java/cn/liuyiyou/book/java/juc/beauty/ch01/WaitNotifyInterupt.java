package cn.liuyiyou.book.java.juc.beauty.ch01;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2020/1/5
 * @Copyright 2020 liuyiyou.cn Inc. All rights reserved
 */
public class WaitNotifyInterupt {

    /**
     * 共享变量
     */
    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        //创建线程
        Thread threadA = new Thread(() -> {
            try {
                System.out.println("--begin--");
                synchronized (obj) {
                    obj.wait();
                }
                System.out.println("--end--");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        threadA.start();
        Thread.sleep(1000);
        System.out.println("--begin interrupt threadA");
        threadA.interrupt();
        System.out.printf("--end interrupt threadA");
    }
}
