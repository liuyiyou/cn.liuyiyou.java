package cn.liuyiyou.java.thread.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Add {

    private volatile int count = 0;

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        Add add = new Add();
        add.doAdd(countDownLatch);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(add.getCount());
    }

    public void doAdd(CountDownLatch countDownLatch) {
        for (int i = 0; i < 4; i++) {
            new Thread(() -> {
                for (int j = 0; j < 250000; j++) {
                    count++;
                }
                countDownLatch.countDown();
            }).start();
        }
    }

    public int getCount() {
        return count;
    }
}
