package cn.liuyiyou.java8.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/***
 * @author: liuyiyou
 * @date: 2018/2/5
 */
public class RangeTest {

    @Test
    public void test1() {
        List<Integer> list = IntStream.range(1, 100).boxed().collect(Collectors.toList());
        System.out.println(list.stream().count());

        //计算列表中元素的平均数
        Double avarage = list.stream().collect(Collectors.averagingInt(item -> item));
        System.out.println(avarage);

        //对列表元素进行统计
        IntSummaryStatistics iss = list.stream().collect(Collectors.summarizingInt(value -> value));
        System.out.println(iss);//IntSummaryStatistics{count=99, sum=4950, min=1, average=50.000000, max=99}


        //根据List创建Map
        Map<Integer, Integer> map = list.stream().collect(Collectors.toMap(p -> p, q -> q * 3));
        System.out.println(map);

        //求列表元素的最大数
        List<Integer> list2 = new Random().ints(-100, 100).limit(250).boxed().collect(Collectors.toList());
        Optional<Integer> max = list2.stream().reduce(Math::max);
        max.ifPresent(value -> System.out.println(value));


        //从一堆姓名列表中找出以字母“C”开头的姓名

        String[] names = {"Fred Edwards", "Anna Cox", "Deborah Patterson", "Ruth Torres", "Shawn Powell",
                "Rose Thompson", "Rachel Barnes", "Eugene Ramirez", "Earl Flores", "Janice Reed", "Sarah Miller",
                "Patricia Kelly", "Carl Hall", "Craig Wright", "Martha Phillips", "Thomas Howard", "Steve Martinez",
                "Diana Bailey", "Kathleen Hughes", "Russell Anderson", "Theresa Perry"};
        List<String> ls = Arrays.asList(names).stream().filter(s -> s.startsWith("C")).collect(Collectors.toList());
        System.out.println(ls.toString());


        //把所有的姓名大写、排序，再输出
        Arrays.asList(names)
                .stream()
                .map(String::toUpperCase)
                .sorted().forEach(System.out::println);
    }
}
