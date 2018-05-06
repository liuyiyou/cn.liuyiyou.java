package cn.liuyiyou.java.thread.concurrent.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/***
 * @author: liuyiyou
 * @date: 2018/3/12
 */
public class UseCountDownLatch {

    private static final int THREAD_COUNT_DOWN = 7;
    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT_DOWN);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i <= THREAD_COUNT_DOWN; i++) {
            int index = i;
            new Thread(() -> {
                System.out.println("第" + index + "颗龙珠已经收集到");
                try {
                    Thread.sleep(new Random().nextInt(3800));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("集齐了7可龙珠");
    }

}
