package cn.liuyiyou.java8.stream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Stream实例
 */
public class StreamExample1 {

    /**
     * Stream创建方式
     */
    @Test
    public void test1() {
        Stream<Integer> stream1 = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
        Stream<Integer> stream2 = Arrays.asList(1, 2, 3, 4, 5).stream();
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);
        Stream<String> stream4 = Stream.of("Java", "Jeff", "Chris", "Python");
        Stream<Integer> stream5 = Stream.of(new Integer[]{1, 2, 3, 4, 5});

        Stream<String> stream = Stream.<String>builder()
                .add("Java")
                .add("Jeff")
                .add("Chris")
                .add("Python")
                .build();

        Stream<String> stream6 = Stream.empty();
    }

    /**
     * 返回由此流的不同元素组成的流,过滤掉重复元素
     */
    @Test
    public void distinct() {
        Stream<Integer> numbersStream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5, 5});
        Stream<Integer> stream = numbersStream.distinct();
        stream.forEach(num -> System.out.print(num + "\t"));
    }

    /**
     * 返回一个流，该流由与此流匹配的此流的指定的断言元素组成
     */
    @Test
    public void filter() {
        Stream<Integer> numbersStream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
        //获得奇数整数流
        Stream<Integer> oddNumbersStream = numbersStream.filter(n -> n % 2 == 1);
        oddNumbersStream.forEach(num -> System.out.print(num + "\t"));
    }

    /**
     * 流里面如果有新的流，然后取单个值
     */
    @Test
    public void flatMap() {
        Stream<Integer> numbersStream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
        Stream<Integer> rStream = numbersStream.flatMap(n -> Arrays.asList(5, 7).stream());
        rStream.forEach(num -> System.out.print(num + "\t"));
        System.out.println();

        Stream<String> stringStream = Arrays.asList("a,bc", "d,ef").stream();
        Stream<String> stringStream1 = stringStream.flatMap(s -> Arrays.asList(s.split(",")).stream());
        stringStream1.forEach(num -> System.out.print(num + "\t"));
    }

    /**
     * 返回由应用指定函数的结果组成的流 这个流的元素
     */
    @Test
    public void map() {
//        Stream<Integer> numbersStream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
//        Stream<Integer> squaredNumbersStream = numbersStream.map(n -> n * n);
//        squaredNumbersStream.forEach(num -> System.out.print(num + "\t"));

        String s = "[\n" +
                "        {\n" +
                "            \"notes\":\"[悉尼-Sydney]运单扫描，正在分拣1\",\n" +
                "            \"optime\":\"2018-09-20 15:46:56\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"notes\":\"[悉尼-Sydney]运单扫描，正在分拣2\",\n" +
                "            \"optime\":\"2018-09-20 15:46:56\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"notes\":\"[悉尼-Sydney]运单扫描，正在分拣3\",\n" +
                "            \"optime\":\"2018-09-20 15:46:56\"\n" +
                "        }\n" +
                "    ]";
        JSONArray jsonArray = JSON.parseArray(s);
        List<JSONObject> jsonObjects = jsonArray.parallelStream().map(i -> {
            JSONObject o = (JSONObject) i;
            o.put("test", "test");
            return o;
        }).collect(toList());


    }




    /**
     * 列表中所有奇数整数的平方和
     */
    @Test
    public void test2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .filter(n -> n % 2 == 1)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }


    @Test
    public void test3() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.parallelStream()
                .filter(n -> n % 2 == 1)
                .map(n -> n * n)
                .reduce(0, Integer::sum);
        System.out.println(sum);
    }
}
