package cn.liuyiyou.java8.stream;

import cn.liuyiyou.model.BuynowProd;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/10/31
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
public class MaxMapExample {

    /**
     * 从一组商品中选出参考价最大的商品
     */

    @Test
    public void test() {
        List<BuynowProd> buynowProds = getBuynowProdsContainSimpleProdId();
        int sum = buynowProds.stream().mapToInt(BuynowProd::getStore).sum();
        Float price = buynowProds.stream().map(BuynowProd::getPrice).max(Float::compareTo).orElse(0F);
        Float price2 = buynowProds.stream().max(Comparator.comparing(BuynowProd::getPrice)).map(BuynowProd::getPrice).orElse(0F);
        System.out.println(sum);
        System.out.println(price);
        System.out.println(price2);

        BuynowProd result = buynowProds.stream().reduce((buynowProd, buynowProd2) -> {
            System.out.println("1"+buynowProd);
            System.out.println("2"+buynowProd2);
            buynowProd.setStore(buynowProd.getStore() + buynowProd2.getStore());
            buynowProd.setPrice(buynowProd.getPrice() > buynowProd2.getPrice() ? buynowProd.getPrice() : buynowProd2.getPrice());
            return buynowProd;
        }).orElse(null);
        System.out.println(result);


    }

    public List<BuynowProd> getBuynowProdsContainSimpleProdId() {
        List<BuynowProd> buynowProdList = new ArrayList<>();
        BuynowProd buynowProd = new BuynowProd();
        buynowProd.setProdId(1001L);
        buynowProd.setSkuId(1001001L);
        buynowProd.setPrice(30F);
        buynowProd.setStore(1);
        buynowProdList.add(buynowProd);

        buynowProd = new BuynowProd();
        buynowProd.setProdId(1001L);
        buynowProd.setSkuId(1001002L);
        buynowProd.setPrice(33F);
        buynowProd.setStore(3);
        buynowProdList.add(buynowProd);


        buynowProd = new BuynowProd();
        buynowProd.setProdId(1001L);
        buynowProd.setSkuId(1001003L);
        buynowProd.setPrice(20F);
        buynowProd.setStore(2);
        buynowProdList.add(buynowProd);

        return buynowProdList;
    }

}
