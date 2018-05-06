package cn.liuyiyou.java.thread;

/***
 * 第一个问题：一个线程访问a1，另外一个线程能否访问a1方法
 不能

 第二个问题：一个线程访问a1，另外一个线程能否访问a2方法
 不能

 第三个问题：一个线程访问a1，另外一个线程能否访问b1方法
 能
 第四个问题：一个线程访问a1，另外一个线程能否访问c1方法
 能
 第五个问题：一个线程访问a1，另外一个线程能否访问d1方法
 能

 第六个问题：一个线程访问b1,另外一个线程能放访问b1方法？
 能
 第七个问题：一个线程访问b1方法，另外一个线程能否访问b2方法
 能

 第八个问题：一个线程访问b1方法，另外一个线程能否访问c1方法
 能

 第九个问题：一个线程访问b1方法，另外一个线程能否访问d1方法
 能

 * @author: liuyiyou
 * @date: 2018/3/15
 */
public class StaticThreadTest {

    public synchronized static void a() throws InterruptedException {
        System.out.println("this is a method");
        Thread.currentThread().sleep(100000l);
    }

    public synchronized static void b() throws InterruptedException {
        System.out.println("this is b method");
        Thread.currentThread().sleep(100000l);
    }

    public synchronized void c() throws InterruptedException {
        System.out.println("this is c method");
        Thread.currentThread().sleep(100000l);
    }

    public static void d() throws InterruptedException {
        System.out.println("this is d method");
        Thread.currentThread().sleep(100000l);
    }

    public void e() throws InterruptedException {
        System.out.println("this is e method");
        Thread.currentThread().sleep(100000l);
    }
}

