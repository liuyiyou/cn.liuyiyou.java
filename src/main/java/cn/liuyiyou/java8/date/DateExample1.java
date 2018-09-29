package cn.liuyiyou.java8.date;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @author: liuyiyou@yanglaoban.com
 * @date: 2018/9/20
 * @version: V1.0
 * @Copyright: 2018 yanglaoban.com Inc. All rights reserved.
 */
public class DateExample1 {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate aDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);
        System.out.println(aDay);
    }
}
