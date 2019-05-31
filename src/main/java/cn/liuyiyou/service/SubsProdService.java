package cn.liuyiyou.service;

import cn.liuyiyou.model.SubsProd;
import cn.liuyiyou.utils.DataSourceUtils;
import com.google.common.collect.Lists;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/4/28
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
public class SubsProdService {

    public static List<SubsProd> nullSubsProds() throws SQLException {
        DataSourceUtils.select("select * from subs_prod limit 10");
        return null;
    }

    public static List<SubsProd> emptySubsProds() {
        return Lists.newArrayList();
    }

//    public static List<SubsProd> getSubsProds() {
//        List<SubsProd> subsProds = new ArrayList<>();
//        IntStream.range(1, 10).forEach(i -> {
//            SubsProd s1 = new SubsProd();
//            s1.setId(i);
//            s1.setProdName("Name" + i);
//            s1.setActId(1L);
//            subsProds.add(s1);
//        });
//        return subsProds;
//    }


    public static List<SubsProd> getSubsProds() {
        List<SubsProd> subsProds = new ArrayList<>();
        SubsProd s1 = new SubsProd();
        s1.setId(1);
        s1.setProdName("1");
        s1.setActId(1L);
        SubsProd s2 = new SubsProd();
        s2.setId(2);
        s2.setActId(2L);
        s2.setProdName("2");
        SubsProd s3 = new SubsProd();
        s3.setId(3);
        s3.setActId(1L);
        s3.setProdName("3");
        SubsProd s4 = new SubsProd();
        s4.setId(4);
        s4.setActId(2L);
        s4.setProdName("4");
        SubsProd s5 = new SubsProd();
        s5.setId(5);
        s5.setActId(1L);
        s5.setProdName("5");
        SubsProd s6 = new SubsProd();
        s6.setId(6);
        s6.setActId(3L);
        s6.setProdName("6");
        subsProds.add(s1);
        subsProds.add(s3);
        subsProds.add(s2);
        subsProds.add(s5);
        subsProds.add(s4);
        subsProds.add(s6);
        return subsProds;
    }

}
