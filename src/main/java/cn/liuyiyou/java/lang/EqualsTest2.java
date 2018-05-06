package cn.liuyiyou.java.lang;

/***
 * @author: liuyiyou
 * @date: 2018/4/23
 */
public  abstract class EqualsTest2 {


    /**
     * main方法
     * @param args  爱的
     */
    public static void main(String[] args) {
        String a = "1";
        Integer b = 1;
        System.out.println(a.equals(b));

        System.out.println(a.equals(String.valueOf(b)));
    }
}
