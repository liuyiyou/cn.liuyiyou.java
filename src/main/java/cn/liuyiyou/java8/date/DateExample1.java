package cn.liuyiyou.java8.date;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateExample1 {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        LocalDate aDay = LocalDate.now().with(TemporalAdjusters.lastDayOfMonth()).minusDays(2);
        System.out.println(aDay);
    }
}
