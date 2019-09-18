package cn.liuyiyou.book.java.thread.action.core;

/**
 * 演示随机性
 *
 * @author: liuyiyou.cn
 * @date: 2019/9/17
 * @version: V1.0
 */
public class Demo_003 extends Thread {

    public static void main(String[] args) throws InterruptedException {
        Demo_003 demo_003 = new Demo_003();
        demo_003.setName("Demo003");
        demo_003.start();
        for(int i =0; i< 10; i++){
            int time = (int) (Math.random() * 1000);
            Thread.sleep(time);
            System.out.println("main=" + Thread.currentThread().getName());
        }
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run=" + Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
