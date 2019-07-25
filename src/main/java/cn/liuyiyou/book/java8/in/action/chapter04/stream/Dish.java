package cn.liuyiyou.book.java8.in.action.chapter04.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 菜肴
 *
 * @author: liuyiyou.cn
 * @date: 2019/7/25
 * @version: V1.0
 */
@AllArgsConstructor
@Data
public class Dish {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public enum Type {
        MEAT, FISH, OTHER
    }

    @Override
    public String toString() {
        return name;
    }
}
