package cn.liuyiyou.java.collection.queue;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/***
 * 优先级队列：堆
 * @author: liuyiyou
 * @date: 2018/2/26
 */
public class PriorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<GregorianCalendar> pg = new PriorityQueue<>();
        pg.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9));
        pg.add(new GregorianCalendar(1815, Calendar.DECEMBER, 10));
        pg.add(new GregorianCalendar(1903, Calendar.DECEMBER, 3));
        pg.add(new GregorianCalendar(1910, Calendar.JULY, 22));

        System.out.println("Iterating over elements");
        for (GregorianCalendar date : pg) {
            System.out.println(date.get(Calendar.YEAR));
        }
        System.out.println("Remove Elements");
        while (!pg.isEmpty()) {
            System.out.println(pg.remove().get(Calendar.YEAR));
        }
    }
}
