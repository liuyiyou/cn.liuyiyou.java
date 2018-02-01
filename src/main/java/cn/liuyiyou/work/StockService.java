package cn.liuyiyou.work;

import cn.liuyiyou.work.entity.BaseActivity;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/***
 * @author: liuyiyou
 * @date: 2018/1/15
 */
public class StockService {

    public boolean hasStock(JSONObject json){
        JSONArray prods = json.getJSONArray("prods");
        Map<Byte, List<Long>> activitTypeSkuIdsMap = Maps.newHashMap();
        Map<Long, Byte> skuIdTypeMap = Maps.newHashMap();
        prods.forEach(prod -> {
            Byte type = JSONObject.parseObject(prod.toString()).getByte("type");
            Long skuId = JSONObject.parseObject(prod.toString()).getLong("skuId");
            skuIdTypeMap.putIfAbsent(skuId, type);
        });
        Set<Byte> types = new HashSet<>();
        skuIdTypeMap.values().forEach(value -> {
            if (value != null) {
                types.add(value);
            }
        });
        types.forEach(type -> {
            List<Long> skuIds = Lists.newArrayList();
            skuIdTypeMap.keySet().forEach(key -> {
                if (skuIdTypeMap.get(key) != null && skuIdTypeMap.get(key).equals(type)) {
                    skuIds.add(key);
                }
            });
            activitTypeSkuIdsMap.putIfAbsent(type, skuIds);
        });

        boolean result = true;
//        for (Byte type : types) {
//            BaseActivity baseActivity = new BaseActivity();
//            baseActivity.setType(type);
//            List<BaseActivity> baseActivities = baseActivityService.searchActivitys(baseActivity);
//            for (Long skuId : activitTypeSkuIdsMap.get(type)) {
//                BuynowProd buynowProd = new BuynowProd();
//                buynowProd.setActId(baseActivities.get(0).getId());
//                buynowProd.setSkuId(skuId);
//                BuynowProd hasStockProd = buynowProdService.findBuynowProd(buynowProd);
//                if (hasStockProd == null) {
//                    throw new BusiException("商品已下架，请重新选择");
//                }
//            }
//        }
        return result;
    }
}
