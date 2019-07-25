package cn.liuyiyou.book.java8.in.action.chap10;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Optional;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/20
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class OptionPerson {
    private Optional<OptionCar> car;
}
