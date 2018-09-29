package cn.liuyiyou.java8.stream;

import org.junit.Test;

import java.util.stream.IntStream;

public class IntStreamExample {

    @Test
    public  void test1(String[] args) {
        IntStream build = IntStream.builder().add(1).add(2).add(3).build();
        // Create an IntStream containing 1, 2, 3, 4, and 5
        IntStream oneToFive = IntStream.range(1, 6);

        // Create an IntStream containing 1, 2, 3, 4, and 5
        IntStream oneToFive2 = IntStream.rangeClosed(1, 5);
    }
}
