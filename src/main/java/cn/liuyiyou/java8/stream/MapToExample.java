package cn.liuyiyou.java8.stream;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * @author: liuyiyou
 * @date: 2018/4/25
 */
public class MapToExample {

    /**
     * 列表求和
     */
    @Test
    public void listSum2() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
        System.out.println(sum2);
    }

    /**
     * 将List中的某个字段求和
     */
    @Test
    public static void listSum() {
//        Optional.ofNullable(getSkus()).map(Sku::getSaled).orElse();

        int sum = getSkus().parallelStream().mapToInt(Sku::getSaled).sum();
        System.out.println(sum);

        List<Sku> nullSkus = null;
        //nullSkus.parallelStream().mapToInt(Sku::getSaled).sum()
//        Integer integer = Optional.ofNullable(nullSkus).ifPresent().orElse(0);
//        System.out.println(integer);
    }

    public static void test() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = numbers.stream();

        //1: filter
        List<Integer> list = stream.filter(integer -> integer / 2 == 0).collect(Collectors.toList());
        list.forEach(integer -> System.out.println(integer));
    }


    public static List<Sku> getSkus() {
        ArrayList<Sku> skus = Lists.newArrayList();
        skus.add(Sku.builder().skuId(10001).saled(10).build());
        skus.add(Sku.builder().skuId(10001).saled(20).build());
        return skus;
    }


}

/**
 * SKU属性
 */
@Data
@Builder
class Sku {
    int skuId;
    int saled;
}