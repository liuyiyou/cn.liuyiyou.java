package cn.liuyiyou.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SubsProd {
    int id;
    Long actId;
    String prodName;


}
