package cn.liuyiyou.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author: liuyiyou.cn
 * @date: 2020/1/7
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class Subs {

    private int subsId;
    private List<SubsProd> prodList;
}
