package cn.liuyiyou.book.jvm.ch02;

/**
 * VM Args： -Xss128k
 *
 * @author: liuyiyou.cn
 * @date: 2019/11/30
 * @version: V1.0
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
