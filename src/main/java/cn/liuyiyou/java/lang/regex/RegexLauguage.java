package cn.liuyiyou.java.lang.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: liuyiyou
 * Date: 14-10-10
 * Time: 下午8:21
 */
public class RegexLauguage {

    public static void main(String[] args) {

        System.out.println("初步认识");
        //?代表一次或者一次也没有
        p("a".matches("a?"));   //true
        p("a".matches("b?"));  //false
        p("aaa".matches("a?"));   //false

        //*代表零次或者多次
        p("a".matches("a*"));    //true
        p("a".matches("b*"));   //false
        p("aaa".matches("a*"));    //true

        //+代表一次或者多次
        p("a".matches("a+")); //true
        p("abc".matches("a+"));  //false

        //a{n}?      a恰好 n 次
        p("abc".matches("a[1]?")); //false
        p("abc".matches("abc{1}?")); //true
        p("abc".matches("abc{2}?")); //false


        System.out.println("范围");

        //范围
        p("a".matches("[abc]"));//true
        p("a".matches("[^abc]"));//false
        p("A".matches("[a-zA-Z]"));//true
        p("A".matches("[a-z]|[A-Z]"));//true
        p("A".matches("[a-z[A-Z]]"));//true
        p("R".matches("[A-Z&&[RFG]]"));//true


        System.out.println("认识\\s \\w \\d \\");

        //认识\s \w \d \
        p("\n\r\t".matches("\\s(4)"));//false
        p(" ".matches("\\S"));//false
        p("a_8 ".matches("\\w(3)"));//false
        p("abc888&^%".matches("[a-z]{1,3}\\d+[&^#%]+"));//true
        p("\\".matches("\\\\"));//true


        // p("abc".matches("[a-z]{3}")); //true
        // p("123".matches("[0-9]{3}")); //true
        // p("123".matches("[0-9]*"));
    }


    /**
     * matches()判断字符串是否匹配某个表达式，"."表示任何一个字符
     */
    public static void matches() {
        boolean result = "abc".matches("...");
        System.out.println(result);

        Pattern p = Pattern.compile("[a-z]{3}");
        //进行匹配，并将匹配结果放在Matcher对象中
        Matcher m = p.matcher("abc");
        System.out.println(m.matches());
    }

    //^[1-9]d*$　
    //匹配正整数
    public static boolean match1() {
        String regex = "^[1-9]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("123");
        return matcher.matches();
    }


    public static void testB() {
        String str = "hi ! his a boy";
        Pattern pattern = Pattern.compile("^b");
        //  System.out.println(result);
    }

    public static void p(boolean result) {
        System.out.println(result);
    }
}
