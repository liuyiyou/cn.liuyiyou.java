package cn.liuyiyou.book.java.juc.beauty.ch01;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2020/1/5
 * @Copyright 2020 liuyiyou.cn Inc. All rights reserved
 */
public class ThreadTest {


    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }


    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
