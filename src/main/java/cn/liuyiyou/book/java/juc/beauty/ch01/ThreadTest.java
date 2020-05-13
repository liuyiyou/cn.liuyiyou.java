package cn.liuyiyou.book.java.juc.beauty.ch01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author: liuyiyou.cn
 * @date: 2020/4/1
 * @version: V1.0
 */
public class ThreadTest {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    MyThread thread = new MyThread();
    thread.start();

    RunnableTask runnableTask = new RunnableTask();
    new Thread(runnableTask).start();
    new Thread(runnableTask).start();

    FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
    new Thread(futureTask).start();

    System.out.println("isDone:" + futureTask.isDone());
    String s = futureTask.get();

    System.out.println(s);
  }

  public static class MyThread extends Thread {

    @Override
    public void run() {
      System.out.println("I am a child thread extend Thread");
    }
  }

  public static class RunnableTask implements Runnable {

    @Override
    public void run() {
      System.out.println("I am a child thread implements Runnable");
    }
  }


  public static class CallerTask implements Callable<String> {

    @Override
    public String call() {
      return "hello";
    }
  }

}
