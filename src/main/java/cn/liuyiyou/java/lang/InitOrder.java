package cn.liuyiyou.java.lang;

/***
 * @author: liuyiyou
 * @date: 2018/5/6
 */
public class InitOrder {


    public InitOrder() {
        System.out.println("构造函数初始化.....");
    }

    static {
        System.out.println("静态代码块初始化.......");
    }

    public static void  staticMethod(){
        System.out.println("静态方法初始化......");
    }


    public void method(){
        System.out.println("常规方法初始化.....");
    }



}
