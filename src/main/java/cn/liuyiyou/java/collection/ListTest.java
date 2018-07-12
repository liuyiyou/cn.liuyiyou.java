package cn.liuyiyou.java.collection;

import com.google.common.collect.Lists;

import java.util.List;

/***
 * @author: liuyiyou
 * @date: 2018/6/20
 */
public class ListTest {


    public static void main(String[] args) {
        List<String>  list = Lists.newArrayList();
        add(list);
        System.out.println(list.size());
    }


    public static void add(List<String> list){

        list.add("a");
        list.add("b");

    }
}
