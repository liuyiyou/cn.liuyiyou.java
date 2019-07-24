package cn.liuyiyou.java.base;

/***
 * @author: liuyiyou
 * @date: 2018/4/23
 */
public class EqualsTest2 {

    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + new String("ming");

        String s4 = "Program" + "ming";
        String s5 = "Pro" + "gram" + "ming";
        System.out.println(s1 == s2); //false
        System.out.println(s1 == s3); //false;
        System.out.println(s1 == s4); //true;
        System.out.println(s1 == s5);//true
    }
}
