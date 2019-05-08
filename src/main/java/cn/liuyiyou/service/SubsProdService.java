package cn.liuyiyou.service;

import cn.liuyiyou.model.SubsProd;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/4/28
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
public class SubsProdService {

    public static List<SubsProd> nullSubsProds() {
        return null;
    }

    public static List<SubsProd> emptySubsProds() {
        return Lists.newArrayList();
    }

    public static List<SubsProd> getSubsProds() {
        List<SubsProd> subsProds = new ArrayList<>();
        IntStream.range(1, 10).forEach(i -> {
            SubsProd s1 = new SubsProd();
            s1.setId(i);
            s1.setProdName("Name" + i);
            s1.setActId(1L);
            subsProds.add(s1);
        });
        return subsProds;
    }
}
