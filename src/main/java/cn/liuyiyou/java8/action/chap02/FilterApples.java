package cn.liuyiyou.java8.action.chap02;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/19
 * @version: V1.0
 */
public class FilterApples {



    @Data
    @Accessors(chain = true)
    public static class Apple {
        private int weight = 0;
        private String color = "";
    }
}
