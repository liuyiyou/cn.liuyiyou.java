package cn.liuyiyou.java.concurrent;

import org.junit.Test;

import java.util.concurrent.Exchanger;

/**
 * @author: liuyiyou.cn
 * @date: 2019/3/8
 * @version: V1.0
 */
public class ExchangerExample {


    /**
     * 测试阻塞
     */
    @Test
    public void  testBlock() {
        Exchanger<String> exchanger = new Exchanger<>();
        ThreadA a = new ThreadA(exchanger);
        a.start();
        System.out.println("main end");
    }


    @Test
    public void  testExchanger() throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<>();
        ThreadA a = new ThreadA(exchanger);
        ThreadB b = new ThreadB(exchanger);
        b.start();
        a.start();
    }


     class ThreadA extends Thread {
        private Exchanger<String> exchanger;

        ThreadA(Exchanger<String> exchanger) {
            super();
            this.exchanger = exchanger;
        }


        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("在线程A中得到线程B的值="+ exchanger.exchange("中国人A"));
                System.out.println("A end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


     class ThreadB extends Thread {
        private Exchanger<String> exchanger;

        ThreadB(Exchanger<String> exchanger) {
            super();
            this.exchanger = exchanger;
        }


        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("在线程B中得到线程A的值="+ exchanger.exchange("中国人B"));
                System.out.println("B end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
