package cn.liuyiyou.book.java8.in.action.chapter04.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author: liuyiyou.cn
 * @date: 2019/7/25
 * @version: V1.0
 */
@Slf4j
public class StreamExample {

    @Test
    public void beforeJava8() {
        List<Dish> menus = Menu.getMenus();
        //筛选低卡路里的菜
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish dish : menus) {
            if (dish.getCalories() < 400) {
                lowCaloricDishes.add(dish);
            }
        }
        //排序
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        //得到低卡路里的菜单名称
        List<String> lowCaloricDishNames = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishNames.add(dish.getName());
        }

        //打印
        for (String name : lowCaloricDishNames) {
            log.info(name);
        }
    }

    @Test
    public void inJava8() {
        List<Dish> menus = Menu.getMenus();
        menus.stream()
                .filter(d -> d.getCalories() < 300)//过滤
                .sorted(Comparator.comparing(Dish::getCalories))//排序
                .map(Dish::getName)//得到名称
                .forEach(log::info);//打印
    }
}
