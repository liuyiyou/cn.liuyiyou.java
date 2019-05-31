/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java8.groupby.GroupByExample.java
 * 日期: 2017年11月8日上午8:50:26
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 */
package cn.liuyiyou.java8.groupby;

import cn.liuyiyou.model.GiftProd;
import cn.liuyiyou.model.SubsProd;
import cn.liuyiyou.service.GiftProdService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static cn.liuyiyou.service.SubsProdService.getSubsProds;

/**
 * @author liuyiyou.cn
 * @date 2017年11月8日 上午8:50:26
 */
public class GroupByExample {


    /**
     * 赠品根据价格区间进行分组,传入一个价格，返回该价格区间的赠品
     */
    @Test
    public void price() {
        System.out.println(groupByquota(45F));
        System.out.println(groupByquota(55F));
        System.out.println(groupByquota(100F));
        System.out.println(groupByquota(200F));
        System.out.println(groupByquota(300F));
    }

    public List<GiftProd> groupByquota(Float price) {
        GiftProdService giftProdService = new GiftProdService();
        List<GiftProd> giftProds = giftProdService.getGiftProds_null();
        return Optional.ofNullable(giftProds).map(giftProds1 -> {
            Map<Float, List<GiftProd>> collect = giftProds1.stream()
                    .filter(giftProd -> price - giftProd.getQuota() >= 0)
                    .collect(Collectors.groupingBy(GiftProd::getQuota));
            return collect.keySet().stream().max(Comparator.comparing(Float::floatValue)).map(collect::get).orElse(null);
        }).orElse(new ArrayList<>());
    }

    public List<GiftProd> groupByquotb(Float price) {
        GiftProdService giftProdService = new GiftProdService();
        List<GiftProd> giftProds = giftProdService.getGiftProds_null();
        Optional<List<GiftProd>> giftProds1 = Optional.ofNullable(giftProds);
        if (giftProds1.isPresent()) {
            Map<Float, List<GiftProd>> collect = giftProds1.get().stream()
                    .filter(giftProd -> price - giftProd.getQuota() >= 0)
                    .collect(Collectors.groupingBy(GiftProd::getQuota));
            return collect.keySet().stream().max(Comparator.comparing(Float::floatValue)).map(collect::get).orElse(null);
        } else {
            return null;
        }


    }


    public List<GiftProd> groupByquota11(Float price) {
        GiftProdService giftProdService = new GiftProdService();
        List<GiftProd> giftProds = giftProdService.getGiftProds();
        Map<Float, List<GiftProd>> quotaGiftProdMap = giftProds.stream()
                .filter(giftProd -> giftProd.getInventory() != null && giftProd.getInventory() > 0)
                .collect(Collectors.groupingBy(GiftProd::getQuota));
        List<Float> collect = quotaGiftProdMap.keySet().stream().filter(key -> price - key >= 0).sorted(Comparator.comparing(Float::floatValue).reversed()).collect(Collectors.toList());
        if (!collect.isEmpty()) {
            return quotaGiftProdMap.get(collect.get(0));
        }
        return null;
    }


    public void groupByquota2(Float price) {
        GiftProdService giftProdService = new GiftProdService();
        List<GiftProd> giftProds = giftProdService.getGiftProds();
        Map<Float, List<GiftProd>> quotaGiftProdMap = giftProds.stream()
                .filter(giftProd -> giftProd.getInventory() != null && giftProd.getInventory() > 0)
//                .sorted((o1, o2) -> {
//                    if (o1.getQuota() - o2.getQuota() < 0) {
//                        return 1;
//                    } else if (o1.getQuota() - o2.getQuota() > 0) {
//                        return -1;
//                    } else {
//                        return 0;
//                    }
//                })
                .collect(Collectors.groupingBy(GiftProd::getQuota));

//        List<Float> collect = quotaGiftProdMap.keySet().stream().sorted().collect(Collectors.toList());
//        AtomicReference<Float> finlayKey = new AtomicReference<>(0F);
//        collect.forEach(key -> {
//            if (price >= key) {
//                finlayKey.set(key);
//            }
//        });
//        quotaGiftProdMap.get(finlayKey.get());

        Optional<Float> first = quotaGiftProdMap.keySet().stream().sorted().filter(key -> price - key >= 0).findFirst();
        first.ifPresent(quotaGiftProdMap::get);
        //if(first.isPresent()){
        //            quotaGiftProdMap.get(first.get());
        //        }
    }

    public void groupByquota3(Float price) {
        GiftProdService giftProdService = new GiftProdService();
        List<GiftProd> giftProds = giftProdService.getGiftProds();
        Map<Float, List<GiftProd>> quotaGiftProdMap = giftProds.stream()
                .filter(giftProd -> giftProd.getInventory() != null && giftProd.getInventory() > 0)
//                .sorted((o1, o2) -> {
//                    if (o1.getQuota() - o2.getQuota() < 0) {
//                        return 1;
//                    } else if (o1.getQuota() - o2.getQuota() > 0) {
//                        return -1;
//                    } else {
//                        return 0;
//                    }
//                })
                .collect(Collectors.groupingBy(GiftProd::getQuota));

//        List<Float> collect = quotaGiftProdMap.keySet().stream().sorted().collect(Collectors.toList());
//        AtomicReference<Float> finlayKey = new AtomicReference<>(0F);
//        collect.forEach(key -> {
//            if (price >= key) {
//                finlayKey.set(key);
//            }
//        });
//        quotaGiftProdMap.get(finlayKey.get());

        Optional<Float> first = quotaGiftProdMap.keySet().stream().sorted().filter(key -> price - key >= 0).findFirst();
        first.ifPresent(quotaGiftProdMap::get);
        //if(first.isPresent()){
        //            quotaGiftProdMap.get(first.get());
        //        }
    }

    @Test
    public void sortTest() {
        List<SubsProd> subsProds = getSubsProds();
        subsProds.stream().sorted(Comparator.comparing(SubsProd::getId)).collect(Collectors.toList())
                .forEach(subsProd -> System.out.println(subsProd.getId()));
        subsProds.stream().sorted(Comparator.comparing(SubsProd::getId)).map(SubsProd::getId).forEach(System.out::println);
    }

    @Test
    public void groupByTest() {
        List<SubsProd> subsProds = getSubsProds();
        Map<Long, List<SubsProd>> actSubsProds = subsProds.stream()
                .collect(Collectors.groupingBy(SubsProd::getActId));
        for (Long key : actSubsProds.keySet()) {
            List<SubsProd> prods = actSubsProds.get(key);
            for (SubsProd p : prods) {
                System.out.println(p.getActId() + "\t" + p.getProdName() + "\t");
            }
            System.out.println("--------------------");
        }
    }

}

