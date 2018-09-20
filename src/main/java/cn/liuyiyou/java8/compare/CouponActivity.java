package cn.liuyiyou.java8.compare;

import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.List;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/7/30
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
public class CouponActivity {

    private Long actId;

    private String name;

    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private static List<CouponActivity> couponActivities(){
        List<CouponActivity> list = Lists.newArrayList();
        CouponActivity couponActivity = new CouponActivity();
        couponActivity.setActId(10002L);
        couponActivity.setName("大的");
        list.add(couponActivity);

        couponActivity = new CouponActivity();
        couponActivity.setActId(10001L);
        couponActivity.setName("小的");
        list.add(couponActivity);
        return list;
    }


    public static void main(String[] args) {
        List<CouponActivity> list = couponActivities();
        list.sort(Comparator.comparing(CouponActivity::getActId));

        System.out.println(list.get(0).actId);
        System.out.println(list.get(1).actId);

        list.sort(Comparator.comparing(CouponActivity::getActId).reversed());

        System.out.println(list.get(0).actId);
        System.out.println(list.get(1).actId);
    }
}
