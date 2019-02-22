package cn.liuyiyou.java.collection.map;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
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

    Byte GRADEID_ORDER_All = (byte) -1;
    Byte GRADEID_ORDER_C = (byte) 0;
    Byte GRADEID_ORDER_M1 = (byte) 1;
    Byte GRADEID_ORDER_M2 = (byte) 2;
    Byte GRADEID_ORDER_M3 = (byte) 3;

    @Test
    public void test() {
        Map<Long, Integer> map = new HashMap<>();
        map.put(11010100050001L, 5);
        map.put(11010100050002L, 5);
        map.put(11010100050003L, 4);
        map.put(11010100050004L, null);
        map.put(11010100050005L, 4);
        map.put(11010100050006L, 3);

        map.compute(11010100050001L, (k, v) -> 1);

        System.out.println(map.get(11010100050001L));

        Map resultMap = new HashMap();

        Set<Integer> types = new HashSet<>();
        map.values().forEach(value -> {
            if (value != null) {
                types.add(value);
            }
        });
        types.forEach(type -> {
            List skuIds = new ArrayList();
            map.keySet().forEach(key -> {
                if (map.get(key) != null && map.get(key).equals(type)) {
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
    public void testDiff() {

        Map<Long, Integer> m1 = new HashMap<>();
        m1.put(17020200080001L, 1);
        m1.put(17020200090001L, 2);
        m1.put(17020200100001L, 2);
        Map<Long, Integer> m2 = new HashMap<>();
        m1.put(17020200090001L, 1);
        m1.put(17020200100001L, 1);
        MapDifference<Long, Integer> difference = Maps.difference(m1, m2);
        System.out.println(difference);
    }

    @Test(expected = NullPointerException.class)
    public void put_putIfAbsent_computeIfAbsent() {
        final Map<Byte, Set<String>> map = new HashMap<>();
        testMap(map);
        map.keySet().forEach(key -> {
            System.out.println(key + "::" + map.get(key));
        });
        System.out.println("-------------------------------");
        map.clear();
        map.put(GRADEID_ORDER_All, Sets.newHashSet("a", "b", "c"));
        testMap(map);
        map.keySet().forEach(key -> {
            System.out.println(key + "::" + map.get(key));
        });

        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        final Map<Byte, Set<String>> map2 = new HashMap<>();
        testMap2(map2);
        map2.keySet().forEach(key -> {
            System.out.println(key + "::" + map2.get(key));
        });
        System.out.println("-------------------------------");
        map2.clear();
        map2.put(GRADEID_ORDER_All, Sets.newHashSet("a", "b", "c"));
        testMap2(map2);
        map2.keySet().forEach(key -> {
            System.out.println(key + "::" + map2.get(key));
        });


        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        final Map<Byte, Set<String>> map3 = new HashMap<>();
        testMap3(map3);
        map3.keySet().forEach(key -> {
            System.out.println(key + "::" + map3.get(key));
        });
        System.out.println("-------------------------------");
        map3.clear();
        map3.put(GRADEID_ORDER_All, Sets.newHashSet("a", "b", "c"));
        testMap3(map3);
        map2.keySet().forEach(key -> {
            System.out.println(key + "::" + map3.get(key));
        });
    }

    private Map<Byte, Set<String>> testMap(Map<Byte, Set<String>> map) {
        Set<String> uidSet = map.get(GRADEID_ORDER_All);
        Set<String> cUidSet = map.get(GRADEID_ORDER_C);
        Set<String> m1UidSet = map.get(GRADEID_ORDER_M1);
        Set<String> m2UidSet = map.get(GRADEID_ORDER_M2);
        Set<String> m3UidSet = map.get(GRADEID_ORDER_M3);
        if (null == uidSet) {
            uidSet = new HashSet<>();
            map.put(GRADEID_ORDER_All, uidSet);
        }
        if (null == cUidSet) {
            cUidSet = new HashSet<>();
            map.put(GRADEID_ORDER_C, cUidSet);
        }
        if (null == m1UidSet) {
            m1UidSet = new HashSet<>();
            map.put(GRADEID_ORDER_M1, m1UidSet);
        }
        if (null == m2UidSet) {
            m2UidSet = new HashSet<>();
            map.put(GRADEID_ORDER_M2, m2UidSet);
        }
        if (null == m3UidSet) {
            m3UidSet = new HashSet<>();
            map.put(GRADEID_ORDER_M3, m3UidSet);
        }
        uidSet.add("F");
        cUidSet.add("F");
        m1UidSet.add("F");
        m2UidSet.add("F");
        m3UidSet.add("F");
        return map;
    }


    private Map<Byte, Set<String>> testMap2(Map<Byte, Set<String>> map) {
        Set<String> uidSet = map.putIfAbsent(GRADEID_ORDER_All, new HashSet<>());
        Set<String> cUidSet = map.putIfAbsent(GRADEID_ORDER_C, new HashSet<>());
        Set<String> m1UidSet = map.putIfAbsent(GRADEID_ORDER_M1, new HashSet<>());
        Set<String> m2UidSet = map.putIfAbsent(GRADEID_ORDER_M2, new HashSet<>());
        Set<String> m3UidSet = map.putIfAbsent(GRADEID_ORDER_M3, new HashSet<>());
        uidSet.add("F");
        cUidSet.add("F");
        m1UidSet.add("F");
        m2UidSet.add("F");
        m3UidSet.add("F");
        return map;
    }

    private Map<Byte, Set<String>> testMap3(Map<Byte, Set<String>> map) {
        Set<String> uidSet = map.computeIfAbsent(GRADEID_ORDER_All, k -> new HashSet<>());
        Set<String> cUidSet = map.computeIfAbsent(GRADEID_ORDER_C, k -> new HashSet<>());
        Set<String> m1UidSet = map.computeIfAbsent(GRADEID_ORDER_M1, k -> new HashSet<>());
        Set<String> m2UidSet = map.computeIfAbsent(GRADEID_ORDER_M2, k -> new HashSet<>());
        Set<String> m3UidSet = map.computeIfAbsent(GRADEID_ORDER_M3, k -> new HashSet<>());
        uidSet.add("F");
        cUidSet.add("F");
        m1UidSet.add("F");
        m2UidSet.add("F");
        m3UidSet.add("F");
        return map;
    }
}
