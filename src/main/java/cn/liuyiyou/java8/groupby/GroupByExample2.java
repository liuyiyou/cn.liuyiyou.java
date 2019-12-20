package cn.liuyiyou.java8.groupby;

import lombok.Data;
import lombok.ToString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author: liuyiyou.cn
 * @date: 2019/12/19
 * @version: V1.0
 */
public class GroupByExample2 {


    //这样一个场景，ProdInfo下面有一个GiftProdActivityVo,GiftProdActivityVo下面有一个ActID，现在要根据ActID进行分组

    @Test
    public void test() {

        List<ProdInfo> prodInfoList = new ArrayList<>();

        ProdInfo prodInfo1 = new ProdInfo();
        GiftProdActivityVo giftProdActivityVo1 = new GiftProdActivityVo();
        giftProdActivityVo1.setActId(1L);
        prodInfo1.setGiftProdActivity(giftProdActivityVo1);
        prodInfoList.add(prodInfo1);

        ProdInfo prodInfo2 = new ProdInfo();
        GiftProdActivityVo giftProdActivityVo2 = new GiftProdActivityVo();
        giftProdActivityVo2.setActId(2L);
        prodInfo2.setGiftProdActivity(giftProdActivityVo2);
        prodInfoList.add(prodInfo2);


        ProdInfo prodInfo3 = new ProdInfo();
        GiftProdActivityVo giftProdActivityVo3 = new GiftProdActivityVo();
        giftProdActivityVo3.setActId(1L);
        prodInfo3.setGiftProdActivity(giftProdActivityVo3);
        prodInfoList.add(prodInfo3);

//        ProdInfo prodInfo4 = new ProdInfo();
//        prodInfoList.add(prodInfo4);

        List<Long> giftActProdInfIds =  prodInfoList.stream().filter(e -> e.getGiftProdActivity() == null).map(ProdInfo::getProdId).collect(toList());
        System.out.println(giftActProdInfIds.size());
        System.out.println(giftActProdInfIds.contains(2L));

        Map<GiftProdActivityVo, List<ProdInfo>> giftProdActivityVoListMap = prodInfoList.stream().filter(e -> e.getGiftProdActivity() != null).collect(Collectors.groupingBy(ProdInfo::getGiftProdActivity));
        giftProdActivityVoListMap.forEach((k, v) -> System.out.println(k.getActId() + "\t" + v));
    }


}

@Data
@ToString
class ProdInfo {

    private Long prodId;
    private GiftProdActivityVo giftProdActivity;

}

@Data
@ToString
class GiftProdActivityVo {

    private Long actId;
}
