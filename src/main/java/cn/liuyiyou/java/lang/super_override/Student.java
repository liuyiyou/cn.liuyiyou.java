package cn.liuyiyou.java.lang.super_override;

import org.apache.commons.lang.StringEscapeUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/5
 * @version: V1.0
 */
public class Student extends Person {

    private String name;

    public Student(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return name;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "G&M 澳芝曼小麦维E修护霜 500g/支";
        String s1 = "G&amp;M 澳芝曼小麦维E修护霜 500g/支";
        String s2 = StringEscapeUtils.unescapeHtml(s);// &amp; ==> &
        String s3 = StringEscapeUtils.unescapeHtml(s1);// &amp; ==> &
        System.out.println(s2.equals(s3));
        System.out.println(s3);

        String encode = URLEncoder.encode("A&B", "utf-8");
        System.out.println(encode);

    }

//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String s = "G&M 澳芝曼小麦维E修护霜 500g/支";
//        String s1 = StringEscapeUtils.escapeHtml(s);// & ==> &amp;
//        String s2 = StringEscapeUtils.unescapeHtml(s);// &amp; ==> &
//        System.out.println(s1);
//        System.out.println(s2);
//
//
//        String encode = URLEncoder.encode(s, "utf-8");
//        System.out.println(encode);
//
//    }


}
