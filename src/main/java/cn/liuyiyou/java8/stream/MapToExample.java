package cn.liuyiyou.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * @author: liuyiyou
 * @date: 2018/4/25
 */
public class MapToExample {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = numbers.stream();

        //1: filter
        List<Integer> list = stream.filter(integer -> integer / 2 == 0).collect(Collectors.toList());
        list.forEach(integer -> System.out.println(integer));
    }
}
