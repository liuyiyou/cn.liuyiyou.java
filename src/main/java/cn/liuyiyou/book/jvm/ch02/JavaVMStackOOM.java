package cn.liuyiyou.book.jvm.ch02;

/**
 * VM Args：-Xss2M
 * @author: liuyiyou.cn
 * @date: 2019/11/30
 * @version: V1.0
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true){}
    }

    public void stackLeakByThread(){
        while (true){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }
}
