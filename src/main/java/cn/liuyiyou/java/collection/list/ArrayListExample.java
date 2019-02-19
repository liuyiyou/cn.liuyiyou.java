package cn.liuyiyou.java.collection.list;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/19
 * @version: V1.0
 */
public class ArrayListExample {

    /**
     * subList 返回的是 ArrayList 的内部类 SubList，并不是 ArrayList
     * 而是 ArrayList 的一个视图，对于 SubList 子列表的所有操作最终会反映到原列表上。
     */
    @Test(expected = ClassCastException.class)
    public void test2() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("liu");
        strings.add("yi");
        strings.add("you");
        ArrayList<String> list = (ArrayList<String>) strings.subList(0, 2);
        System.out.println(list.size());
    }
}
