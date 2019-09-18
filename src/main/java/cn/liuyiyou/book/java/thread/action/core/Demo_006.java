package cn.liuyiyou.book.java.thread.action.core;

/**
 * 演示数据不共享的情况:有点疑问：count不是成员变量么？应该是为多个线程共享才对啊
 *
 * @author: liuyiyou.cn
 * @date: 2019/9/17
 * @version: V1.0
 */
public class Demo_006 extends Thread {

    private static int count = 5;

    public Demo_006(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        while (count > 0) {
            count--;
            System.out.println("由" + currentThread().getName() + "计算,count=" + count);
        }
    }

    public static void main(String[] args) {
        Demo_006 a = new Demo_006("A");
        Demo_006 b = new Demo_006("B");
        Demo_006 c = new Demo_006("C");
        a.start();
        b.start();
        c.start();
    }
}
