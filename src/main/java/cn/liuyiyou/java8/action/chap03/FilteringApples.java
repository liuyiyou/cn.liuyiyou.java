package cn.liuyiyou.java8.action.chap03;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/18
 * @version: V1.0
 */
public class FilteringApples {


    public static void main(String[] args) throws IOException {


        //布尔表达式
        Function<List<String>, Object> a = (List<String> list) -> list.isEmpty();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("xxx");
            }
        };

        Runnable runnable2 = () -> System.out.println("xxx");

        processFile(bufferedReader -> bufferedReader.readLine() + bufferedReader.readLine());

    }


    public static String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    //使用函数式接口传递行为
    public static String processFile(BufferedReaderProcessor processor) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            //执行行为
            return processor.process(br);
        }
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }


    public static List<Apple> filter(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    @Data
    @Accessors(chain = true)
    public static class Apple {
        private int weight = 0;
        private String color = "";
    }


    interface ApplePredicate<T> {
        boolean test(Apple apple);
    }

    static class AppleWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    static class AppleColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }

    static class AppleRedAndHeavyPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return "red".equals(apple.getColor()) && apple.getWeight() > 150;
        }
    }
}

