package cn.liuyiyou.java.lang;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/***
 * @author: liuyiyou
 * @date: 2018/5/4
 */
public class CompareTest {


    public static void main(String[] args) {
        /**
         * 如果指定的数与参数相等返回0。

         *如果指定的数小于参数返回 -1。

         *如果指定的数大于参数返回 1。
         */
        System.out.println("a".compareTo("b"));


        List list = Arrays.asList("1", "2", "3", "5", "4");
        list.sort(Comparator.comparing(Function.identity()));
        System.out.println(list);
    }
}
