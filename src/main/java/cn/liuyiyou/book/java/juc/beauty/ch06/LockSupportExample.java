package cn.liuyiyou.book.java.juc.beauty.ch06;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import org.junit.Test;

/**
 * 它的主要作用是挂起和唤醒线程，该工具类是创建锁和其他同步类的基础。
 *
 * @author: liuyiyou.cn
 * @date: 2020/4/1
 * @version: V1.0
 */
public class LockSupportExample {

  public static void main(String[] args) {

  }


  /**
   * 只会输出begin park!，然后当前线程被挂起，这是因为在默认情况下调用线程是不持有许可证的。
   */
  @Test
  public void parkTest() {
    System.out.println("begin park!");
    LockSupport.park();
    System.out.println("end park!");
  }

  @Test
  public void upparkTest(){
    System.out.println("begin park!");
    LockSupport.unpark(Thread.currentThread());
    LockSupport.park();
    System.out.println("end park");
  }

}
