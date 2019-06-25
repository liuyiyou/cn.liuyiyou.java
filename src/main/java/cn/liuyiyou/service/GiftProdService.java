package cn.liuyiyou.service;

import cn.liuyiyou.model.GiftProd;

import java.util.ArrayList;
import java.util.List;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/5/30
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
public class GiftProdService {


    public List<GiftProd> getGiftProds_empty() {
        return new ArrayList<>();
    }

    public List<GiftProd> getGiftProds_null() {
        return null;
    }


    public List<GiftProd> getGiftProds() {
        List<GiftProd> giftProds = new ArrayList<>();
        GiftProd giftProd = new GiftProd();
        giftProd.setActId(101L)
                .setBossProdId(101001L)
                .setBossProdId(101001001L)
                .setInventory(30)
                .setQuota(100F)
                .setStatus((byte) 1);
        giftProds.add(giftProd);

        giftProd = new GiftProd();
        giftProd.setActId(101L)
                .setBossProdId(101001L)
                .setBossProdId(101001001L)
                .setInventory(30)
                .setQuota(100F)
                .setStatus((byte) 1);
        giftProds.add(giftProd);

        giftProd = new GiftProd();
        giftProd.setActId(101L)
                .setBossProdId(101001L)
                .setBossProdId(101001001L)
                .setInventory(30)
                .setQuota(50F)
                .setStatus((byte) 1);
        giftProds.add(giftProd);


        giftProd = new GiftProd();
        giftProd.setActId(101L)
                .setBossProdId(101001L)
                .setBossProdId(101001001L)
                .setInventory(30)
                .setQuota(50F)
                .setStatus((byte) 1);
        giftProds.add(giftProd);


        giftProd = new GiftProd();
        giftProd.setActId(101L)
                .setBossProdId(101001L)
                .setBossProdId(101001001L)
                .setInventory(30)
                .setQuota(200F)
                .setStatus((byte) 1);
        giftProds.add(giftProd);

        giftProd = new GiftProd();
        giftProd.setActId(101L)
                .setBossProdId(101001L)
                .setBossProdId(101001001L)
                .setInventory(30)
                .setQuota(200F)
                .setStatus((byte) 1);

        giftProds.add(giftProd);
        return giftProds;
    }
}
