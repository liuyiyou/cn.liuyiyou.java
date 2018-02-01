package cn.liuyiyou.java.thread;

/**
 * User: liuyiyou
 * Date: 14-9-16
 * Time: 下午7:36
 * Desc: java核心技术第七版
 */
public class Thread4 {

    //不是线程，但是用到了线程
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("i: " + i);
            if (i % 10 == 0) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Delay");
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread4().run();
    }
}
