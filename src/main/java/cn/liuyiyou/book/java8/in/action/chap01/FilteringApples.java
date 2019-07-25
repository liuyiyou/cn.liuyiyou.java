package cn.liuyiyou.book.java8.in.action.chap01;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparingInt;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/18
 * @version: V1.0
 */
public class FilteringApples {


    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple().setWeight(80).setColor("green"),
                new Apple().setWeight(155).setColor("green"),
                new Apple().setWeight(120).setColor("red"));


        //排序- 匿名类
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });


        //排序-lambda
        inventory.sort((o1, o2) -> o1.getWeight() - o2.getWeight());

        //排序-工具类
        inventory.sort(Comparator.comparingInt(Apple::getWeight));


        System.out.println(inventory);

        inventory.sort(comparingInt(Apple::getWeight));
        //
        List<Apple> greenApples = filterApplesByColor(inventory, "green");
        System.out.println(greenApples);

        List<Apple> redApples = filterApplesByColor(inventory, "red");
        System.out.println(redApples);


        List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
        System.out.println(greenApples2);

        List<Apple> heaveApples = filter(inventory, new AppleWeightPredicate());
        System.out.println(heaveApples);


        List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

        List<Apple> redApples2 = filter(inventory, apple -> apple.getColor().equals("red"));
        System.out.println(redApples2);

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

