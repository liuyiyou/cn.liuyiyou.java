package cn.liuyiyou.book.java8.in.action.chap05;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/11/14
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
public class StreamExample {


    /**
     * 5.1.2
     * 1:用谓词进行筛选
     * 2:distinct过滤重复元素
     */
    @Test
    public void filter() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }


    /**
     * 5.1.2
     * 1:用谓词进行筛选
     * 2:distinct过滤重复元素
     */
    @Test
    public void test() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

}
