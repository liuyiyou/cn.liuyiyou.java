package cn.liuyiyou.java.collection.set;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: liuyiyou.cn
 * @date: 2019/5/6
 * @version: V1.0
 */
public class SetsUtilsTest {

    //测试交集
    @Test
    public void testIntersection(){
        Set<Long> set1 = new HashSet<>();
        set1.add(1L);
        set1.add(2L);
        set1.add(3L);

        Set<String> set2 = new HashSet<>();
        set2.add("2");
        set2.add("3");

        Sets.SetView<Long> intersection = Sets.intersection(set1, set2);
        Object[] objects = intersection.toArray();
        System.out.println(objects.length);
    }

    @Test
    public void testIntersection2(){
        Set<String> set1 = new HashSet<>();
        set1.add("1");
        set1.add("2");
        set1.add("3");


        Set<String> set2 = new HashSet<>();
        set2.add("2");
        set2.add("3");

        Sets.SetView<String> intersection = Sets.intersection(set1, set2);
        Object[] objects = intersection.toArray();
        System.out.println(objects.length);
    }
}
