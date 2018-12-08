package cn.liuyiyou.java.json;


import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import org.junit.Test;

import java.util.Map;

/**
 * FastJson实例
 */
public class FastJsonExample {

    /**
     * parseObject引起的问题
     */

    @Test(expected = ClassCastException.class)
    @SuppressWarnings("unchecked")
    public void parseObject2Map() {
        String str = "{12345679:1}";
        //uncheck ass
        Map<String, Integer> skuIdNumMap = JSONObject.parseObject(str, Map.class, Feature.DisableFieldSmartMatch);
        for (String skuId : skuIdNumMap.keySet()) {
            System.out.println(skuId);
        }

        System.out.println(skuIdNumMap);
    }

    /**
     * 正常解析
     */
    @Test
    @SuppressWarnings("unchecked")
    public void parseObject2Map2() {
        String str = "{12345679:1}";
        //uncheck ass
        Map skuIdNumMap = JSONObject.parseObject(str, Map.class);
        for (Object skuId : skuIdNumMap.keySet()) {
            System.out.println(skuId);
        }
    }
}
