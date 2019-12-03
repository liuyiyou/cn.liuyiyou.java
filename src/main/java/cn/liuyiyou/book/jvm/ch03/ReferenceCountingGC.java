package cn.liuyiyou.book.jvm.ch03;

/**
 * VM args   -verbose:gc -XX:+PrintGCDetails
 * testGC()方法执行后，objA和objB会不会被GC?
 * @author: liuyiyou.cn
 * @date: 2019/11/30
 * @version: V1.0
 */
public class ReferenceCountingGC {

    public Object install = null;
    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];


    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.install = objB;
        objB.install = objA;

        objA = null;
        objB = null;

        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
