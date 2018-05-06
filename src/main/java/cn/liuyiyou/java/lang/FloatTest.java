package cn.liuyiyou.java.lang;

/***
 * @author: liuyiyou
 * @date: 2018/3/15
 */
public class FloatTest {

    public static void main(String[] args) {
        float f1 = 0f;
        float f2 = 0.0f;
        System.out.println(f1 == f2); //true


        Float f11 = 0f;
        Float f12 = 0.0f;
        Float f13 = 0f;
        System.out.println(f11 == f12); //false
        System.out.println(f11.equals(f12));//true
        System.out.println(f11 == f13); //false


        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1.equals(i2));//true
        System.out.println(i1 == i2);//true


        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3.equals(i4));//true
        System.out.println(i3 == i4);//false
    }
}
