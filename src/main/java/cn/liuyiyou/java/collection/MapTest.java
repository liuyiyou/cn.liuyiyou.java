package cn.liuyiyou.java.collection;

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
public class MapTest {


    @Test
    public void test() {
        Map map = new HashMap();
        map.put(11010100050001L, 5);
        map.put(11010100050002L, 5);
        map.put(11010100050003L, 4);
        map.put(11010100050004L, null);
        map.put(11010100050005L, 4);
        map.put(11010100050006L, 3);

        Map resultMap = new HashMap();

        Set types = new HashSet<>();
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
}
