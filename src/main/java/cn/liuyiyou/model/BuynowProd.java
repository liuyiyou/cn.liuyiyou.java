package cn.liuyiyou.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class BuynowProd {
    private Long prodId;
    private Long skuId;
}
