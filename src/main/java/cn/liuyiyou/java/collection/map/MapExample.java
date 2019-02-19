package cn.liuyiyou.java.collection.map;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/***
 * @author: liuyiyou
 * @date: 2018/1/14
 */
public class MapExample {


    @Test
    public void test() {
        Map<Long,Integer> map = new HashMap();
        map.put(11010100050001L, 5);
        map.put(11010100050002L, 5);
        map.put(11010100050003L, 4);
        map.put(11010100050004L, null);
        map.put(11010100050005L, 4);
        map.put(11010100050006L, 3);

        Map resultMap = new HashMap();

        Set<Integer> types = new HashSet<>();
        map.values().forEach(value -> {
            if(value!=null){
                types.add(value);
            }
        });
        types.forEach(type -> {
            List skuIds = new ArrayList();
            map.keySet().forEach(key -> {
                if (map.get(key)!=null && map.get(key).equals(type)) {
                    skuIds.add(key);
                }
            });
            resultMap.putIfAbsent(type, skuIds);
        });
        resultMap.keySet().forEach(key -> {
            System.out.println(resultMap.get(key));
        });
    }

    @Test
    public void testDiff(){

        Map<Long ,Integer> m1 = new HashMap<>();
        m1.put(17020200080001L,1);
        m1.put(17020200090001L,2);
        m1.put(17020200100001L,2);
        Map<Long ,Integer> m2 = new HashMap<>();
        m1.put(17020200090001L,1);
        m1.put(17020200100001L,1);
        MapDifference<Long, Integer> difference = Maps.difference(m1, m2);
        System.out.println(difference);
    }
}
