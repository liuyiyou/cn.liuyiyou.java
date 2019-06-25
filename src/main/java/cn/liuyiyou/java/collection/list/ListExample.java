package cn.liuyiyou.java.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

import org.junit.Test;

/***
 * @author: liuyiyou
 * @date: 2018/6/20
 */
public class ListExample {

    /**
     * 使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方 法， 它的 add/remove/clear 方法会抛出
     * UnsupportedOperationException 异常。
     * <p>
     * <p>
     * 返回的是Arrays中的一个内部类，该内部类并没有实现add方法
     */
    @Test(expected = UnsupportedOperationException.class)
    public void test1() {
        String[] str = new String[] { "liu", "yi" };
        List<String> list = Arrays.asList(str);
        list.add("you");
    }

    @Test
    public void test3() {
        List<String> strings = new ArrayList<>();
        strings.add("liu");
        strings.add("yi");
        strings.add("you");

        String[] strings1 = strings.toArray(new String[] {});
        System.out.println(strings1.length);
        System.out.println(strings1[0] + "\t" + strings1[1] + "\t" + strings1[2]);

    }

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        add(list);
        System.out.println(list.size());
    }

    @Test
    public void test4() {
    }

    public static void add(List<String> list) {

        list.add("a");
        list.add("b");

    }
}
