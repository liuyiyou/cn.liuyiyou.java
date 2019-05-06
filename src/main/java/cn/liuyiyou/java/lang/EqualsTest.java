package cn.liuyiyou.java.lang;

import org.junit.Test;

/**
 * @author: liuyiyou.cn
 * @date: 2019/5/6
 * @version: V1.0
 */
public class EqualsTest {

    /**
     *
     */
    @Test
    public void test1() {
        Integer a = 1;
        Integer b = 1;
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }


    @Test
    public void test2() {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }


    @Test
    public void test3() {
        Float a = 1F;
        Float b = 1F;
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }


    @Test
    public void testString() {
        String a = "a";
        String b = "a";
        System.out.println(a == b);
        System.out.println(a.equals(b));


        String c = a;
        System.out.println(a == c);

        String d = a;
        System.out.println(a == d);


        String e = new String("e");
        String f = new String("e");
        System.out.println(e.equals(f));
        System.out.println(e == f);
    }
}
