package cn.liuyiyou.java.lang;

import org.junit.Test;

/***
 * @author: liuyiyou
 * @date: 2018/1/16
 */
public class StringTest {


    @Test
    public void equalsTest(){
        String str = "1234";
        Integer integer  = 1234;
        System.out.println(str.equals(integer));
    }

    @Test
    public void getBytesTest(){
        String s = "123456";
        System.out.println(s.getBytes());
        System.out.println(s.getBytes());
        System.out.println(s.getBytes());
    }


    @Test
    public void deleteChartAtTest(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("aaaaa;");
        String s = stringBuffer.deleteCharAt(stringBuffer.length()-1).toString();
        System.out.println(s);
    }
}
