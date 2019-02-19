package cn.liuyiyou.java.date;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Calendar;
import java.util.Date;

/***
 * @author: liuyiyou
 * @date: 2018/7/17
 */
public class DateExample {





    public static void main(String[] args) {
        Date  date = new Date();
        Calendar.getInstance().setTime(date);
        String s = DateUtils.truncate(date, Calendar.YEAR).toString();
        System.out.println(s);
        System.out.println(date.getMonth());
        System.out.println(date.getDay());
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH)+1;
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        System.out.println(year+"\t"+month+"\t"+day);
    }
}
