package cn.liuyiyou.java.json;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

/***
 * @author: liuyiyou
 * @date: 2018/7/19
 */
public class LongToString {

    @JSONField(serialzeFeatures = SerializerFeature.WriteNonStringKeyAsString)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static void main(String[] args) {
        LongToString longToString = new LongToString();
        longToString.setId(System.currentTimeMillis());
        System.out.println(longToString.getId());
    }
}
