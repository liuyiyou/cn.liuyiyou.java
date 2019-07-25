package cn.liuyiyou.book.java8.in.action.chapter04.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2019/7/25
 * @version: V1.0
 */
public class Menu {


    public static List<Dish> getMenus(){
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("pork",false,800, Dish.Type.MEAT));
        menu.add(new Dish("beef",false,700, Dish.Type.MEAT));
        menu.add(new Dish("chicken",false,400, Dish.Type.MEAT));
        menu.add(new Dish("frence fries",true,800, Dish.Type.OTHER));
        menu.add(new Dish("rice",true,800, Dish.Type.OTHER));
        menu.add(new Dish("season fruit",true,120, Dish.Type.OTHER));
        menu.add(new Dish("pizza",true,550, Dish.Type.OTHER));
        menu.add(new Dish("prawns",false,300, Dish.Type.FISH));
        menu.add(new Dish("salmon",false,450, Dish.Type.FISH));
        return menu;
    }
}
