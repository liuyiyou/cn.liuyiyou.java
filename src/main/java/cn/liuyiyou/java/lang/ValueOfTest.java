package cn.liuyiyou.java.lang;

/***
 * valueOf(xxx)方法xxx不能为null，否则报NPE异常
 * @author: liuyiyou
 * @date: 2018/1/14
 */
public class ValueOfTest {

    public static void main(String[] args) {
        try {
            System.out.println(Integer.parseInt(null));
            System.out.println(String.valueOf(null));
            System.out.println(String.valueOf("1"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(String.valueOf("2"));
        }
        try {
            System.out.println(Byte.valueOf(null));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
