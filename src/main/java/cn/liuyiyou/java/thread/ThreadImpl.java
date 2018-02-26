/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.thread.ThreadImpl.java
 * 日期: 2017年8月9日下午10:38:57
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 */
package cn.liuyiyou.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import static java.lang.Thread.sleep;

/**
 * 实现线程的几种方式
 *
 * @author liuyiyou.cn
 * @date 2017年8月9日 下午10:38:57
 */
public class ThreadImpl extends Thread {

    public static void main(String[] args) {
        new ExtendThread("A").start();
        new Thread(new ImplRunnable("B")).start();
        new Thread(new FutureTask(new ImplCallable("C"))).start();
    }

}


/**
 * 继承Thread
 */
class ExtendThread extends Thread {
    private String name;

    public ExtendThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        DoSomething.doSomething(name);
    }
}


/**
 * 实现Runnable接口
 */
class ImplRunnable implements Runnable {

    private String name;

    public ImplRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        DoSomething.doSomething(name);
    }
}

class ImplCallable implements Callable {

    private String name;

    public ImplCallable(String name) {
        this.name = name;
    }

    @Override
    public Object call() throws Exception {
        DoSomething.doSomething(name);
        return null;
    }
}


class DoSomething {

    public static void doSomething(String name) {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}