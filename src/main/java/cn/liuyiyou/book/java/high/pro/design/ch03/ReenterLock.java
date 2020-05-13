package cn.liuyiyou.book.java.high.pro.design.ch03;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: liuyiyou.cn
 * @date: 2020/5/13
 * @version: V1.0
 */
public class ReenterLock implements Runnable {

  //可重入锁
  public static ReentrantLock lock = new ReentrantLock();

  public static int i = 0;

  @Override
  public void run() {
    for (int j = 0; j < 10000000; j++) {
      lock.lock();
      try {
        i++;
      } finally {
        lock.unlock();
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {
    ReenterLock reentrantLock = new ReenterLock();
    Thread t1 = new Thread(reentrantLock);
    Thread t2 = new Thread(reentrantLock);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(i);
  }
}
