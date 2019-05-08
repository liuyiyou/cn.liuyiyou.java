package cn.liuyiyou.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SubsProd {
    private int id;
    private Long actId;
    private String prodName;
    private Float taxPrice;
    private Float taxRate;
}
