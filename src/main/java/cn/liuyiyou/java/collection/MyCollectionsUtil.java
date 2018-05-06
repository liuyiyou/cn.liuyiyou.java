package cn.liuyiyou.java.collection;

import java.util.Collection;
import java.util.Iterator;

/***
 * @author: liuyiyou
 * @date: 2018/4/23
 */
public class MyCollectionsUtil {


    public static void doSomething(Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object object = iterator.next();
            //do something to object here;
        }
    }
}
