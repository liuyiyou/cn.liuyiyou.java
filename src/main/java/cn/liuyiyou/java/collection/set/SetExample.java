package cn.liuyiyou.java.collection.set;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Set;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/9/14
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
public class SetExample {


    /**
     * 测试交集
     */
    @Test
    public void testRetail() {
        Set<Integer> s1 = Sets.newHashSet(1, 2, 3);
        Set<Integer> s2 = Sets.newHashSet(2, 3, 4);

        System.out.println("{1,2,3} 交集 {2,3,4}" + s1.retainAll(s1));

        Sets.SetView<Integer> union = Sets.intersection(s1, s2);
        System.out.println(union.size());


        Set<Integer> retainAll = Sets.newHashSet();
        retainAll.addAll(s1);
        retainAll.retainAll(s2);
        System.out.println(retainAll);
        System.out.println(s1.contains(s2));

        System.out.println(s1);
        System.out.println(s2);
    }
}
