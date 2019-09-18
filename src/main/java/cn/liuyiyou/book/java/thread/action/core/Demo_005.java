package cn.liuyiyou.book.java.thread.action.core;

/**
 * 演示数据不共享的情况:有点疑问：count不是成员变量么？应该是为多个线程共享才对啊
 * 这样理解：每次都是New了一个对象，成员变量也称作实例变量、属性， 申明在类之中，方法之外的变量，随对象销毁而销毁。
 * @author: liuyiyou.cn
 * @date: 2019/9/17
 * @version: V1.0
 */
public class Demo_005 extends Thread {

    private int count = 5;
    public Demo_005(String name) {
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
        Demo_005 a = new Demo_005("A");
        Demo_005 b = new Demo_005("B");
        Demo_005 c = new Demo_005("C");
        a.start();
        b.start();
        c.start();
    }
}
