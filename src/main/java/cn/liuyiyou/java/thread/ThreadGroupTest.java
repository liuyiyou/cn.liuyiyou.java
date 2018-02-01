package cn.liuyiyou.java.thread;

/**
 * User: liuyiyou
 * Date: 14-9-16
 * Time: 下午8:57
 */
public class ThreadGroupTest {

    public void threadGroupTest(ThreadGroup threadGroup){
        Thread thread1 = new Thread(threadGroup,"thread1"){
            @Override
            public void run() {
                while (true){
                    System.out.println("thread1 Run");
                }
            }
        };
        thread1.start();

        Thread thread2 = new Thread(threadGroup,"thread2"){
            @Override
            public void run() {
                while (true){
                    System.out.println("thread2 Run");
                }
            }
        };
        thread2.start();

        Thread thread3 = new Thread(threadGroup,"thread3"){
            @Override
            public void run() {
                while (true){
                    System.out.println("thread3 Run");
                }
            }
        };
        thread3.start();

        Thread thread4 = new Thread(threadGroup,"thread4"){
            @Override
            public void run() {
                while (true){
                    System.out.println("thread4 Run");
                }
            }
        };
        thread4.start();
    }

    public static void main(String[] args) {

        ThreadGroup threadGroup = new ThreadGroup("myGroup");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        new ThreadGroupTest().threadGroupTest(threadGroup);



        threadGroup.interrupt();
    }
}
