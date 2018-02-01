package cn.liuyiyou.java.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * User: liuyiyou
 * Date: 14-11-5
 * Time: 下午9:08
 * Desc: 需求：比较set表中的数据
 */
public class MyTest {

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<Integer>();
        for (int i = 0 ; i < 10; i++){
           set1.add(i);
        }

        Set<Integer> set2 = new HashSet<Integer>();
        set2.add(1);
        set2.add(3);
        set2.add(5);
        set2.add(7);


        Iterator<Integer> iter = set1.iterator();

        while (iter.hasNext()){
            if (!set2.contains(iter.next())){
                iter.remove();
               // set1.remove(iter.next());这个不能使用，会出现ConcurrentModificationException异常
               //http://www.2cto.com/kf/201403/286536.html
            }
        }

        System.out.println(set1);

      //  join();

    }

    /**
     * 两个集合取交集
     * */
   public static void join(){
       //在另外一个表中查出来的ids
       Set<Integer> set1 = new HashSet<Integer>();
       for (int i = 0 ; i < 10; i++){
           set1.add(i);
       }

       Set<Integer> set2 = new HashSet<Integer>();
       set2.add(1);
       set2.add(3);
       set2.add(5);
       set2.add(7);



       //两个集合取交集
       set2.retainAll(set1);



       //如果该id已经在上面，则
       System.out.println(set2);
   }
 }
