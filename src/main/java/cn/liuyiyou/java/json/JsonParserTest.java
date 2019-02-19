package cn.liuyiyou.java.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/***
 * @author: liuyiyou
 * @date: 2018/6/19
 */
public class JsonParserTest {

    public static void main(String[] args) {
        String s = JSON.toJSONString(getProds());
        System.out.println(s);

        //type= jsonobject
        ArrayList arrayList = JSON.parseObject(s, ArrayList.class);
        System.out.println(arrayList);

        //type = Prod
        ArrayList<Prod> prods = JSON.parseObject(s,new TypeReference<ArrayList<Prod>>(){});
        System.out.println(prods);
    }


   public static List<Prod> getProds(){
       List<Prod> prods = Lists.newArrayList();
        IntStream.range(1,10).forEach(i->{
                Prod p  = new Prod();
                p.setId(i);
                p.setName("N"+i);
                prods.add(p);

        });
        return prods;
    }
}
