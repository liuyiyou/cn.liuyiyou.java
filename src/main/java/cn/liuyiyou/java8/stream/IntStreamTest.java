package cn.liuyiyou.java8.stream;

import java.util.stream.IntStream;

public class IntStreamTest {

    public static void main(String[] args) {
        IntStream build = IntStream.builder().add(1).add(2).add(3).build();
    }
}
