package cn.liuyiyou.java.lang.super_override;

import lombok.Data;

/**
 * @author: liuyiyou.cn
 * @date: 2019/8/5
 * @version: V1.0
 */
@Data
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
        this.name = "bb";

    }
}
