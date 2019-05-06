package cn.liuyiyou.java.thread;

/**
 * @author: liuyiyou.cn
 * @date: 2019/5/6
 * @version: V1.0
 */
public class SynchronizedTest extends   Thread{


    public static void main(String[] args) {
        for(int i = 0 ; i < 100; i++){
            new SynchronizedTest("081susMB0EzWyi2E5uLB03akMB0susMn"+i).start();
        }
    }

    private String code;

    public SynchronizedTest(String code) {
        this.code = code;
    }

    @Override
    public void run() {
        synchronizedLocalVariable(code);
    }

    public void synchronizedLocalVariable(String code){
        System.out.println("外层:"+code);
        synchronized (this){
            System.out.println("内层:"+code);
        }
    }
}
