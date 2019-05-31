package cn.liuyiyou.model;

import lombok.Data;
import lombok.experimental.Accessors;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/5/30
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
@Data
@Accessors(chain = true)
public class GiftProd {

    private Long id;
    private Long actId;
    private Long bossProdId;
    private Long bossSkuId;
    private String title;
    private Integer inventory;
    private Byte status;
    private Float quota;

}
