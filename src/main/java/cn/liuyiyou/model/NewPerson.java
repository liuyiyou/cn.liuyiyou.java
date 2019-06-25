package cn.liuyiyou.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author: liuyiyou.cn
 * @date: 2019/6/4
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class NewPerson {

    private int id;
    private String name;
    private Date birthDay;
}
