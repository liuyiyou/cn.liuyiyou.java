package cn.liuyiyou.java.lang;

import org.junit.Test;

/***
 * @author: liuyiyou
 * @date: 2018/4/23
 */
public class EqualsExample {


  /**
   * 不同类型永远为false
   */
  @Test
  public void testDiffType() {
    String a = "1";
    Integer b = 1;
    System.out.println(a.equals(b));
    System.out.println(a.equals(String.valueOf(b)));
  }


  /**
   * 等于
   */
  @Test
  public void stringEqualsTest() {
    String s1 = "Programming";
    String s2 = new String("Programming");
    String s3 = "Program" + new String("ming");
    String s4 = "Program" + "ming";
    String s5 = "Pro" + "gram" + "ming";

    System.out.println("equals比较开始......");
    //==== String重写了eqluse方法，只比较值
    System.out.println(s1.equals(s2));
    System.out.println(s1.equals(s3));
    System.out.println(s1.equals(s4));
    System.out.println(s1.equals(s5));

    System.out.println("=比较开始......");
    // 当s1="Programming";  String是 final在常量池中，   new String 存放对象实例是java堆，他们的地址肯定不一样，显示false
    System.out.println(s1 == s2);
    // s3 //false;
    System.out.println(s1 == s3);
    System.out.println(s1 == s4); //true;
    System.out.println(s1 == s5);//true
  }


}
