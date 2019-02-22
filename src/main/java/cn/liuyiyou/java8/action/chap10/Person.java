package cn.liuyiyou.java8.action.chap10;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/20
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class Person {
    private Car car;
}
