package cn.liuyiyou.java8.stream;

import cn.liuyiyou.model.Subs;
import cn.liuyiyou.model.SubsProd;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author: liuyiyou.cn
 * @date: 2020/1/7
 * @version: V1.0
 */
public class StreamReduceExample {


    /**
     * 应用缩减操作来计算流中的单个值
     */
    @Test
    public void simpleReduce() {
        Stream<Integer> numbersStream = Arrays.stream(new Integer[]{1, 2, 3, 4, 5});
        int sum = numbersStream.reduce(0, (n1, n2) -> n1 + n2);
        int sum2 = numbersStream.reduce(0, Integer::sum);
        System.out.println(sum == sum2);
    }

    /**
     * 订单里面包含商品，商品里面包含商品数量，统计多个所有商品数量之和
     */
    @Test
    public void test() {

        List<Subs> subsList = getSubsList();
        //常规方法
        int prodTotal = 0;
        for (Subs subs : subsList) {
            List<SubsProd> prodList = subs.getProdList();
            for (SubsProd subsProd : prodList) {
                prodTotal += subsProd.getProdNum();
            }
        }
        System.out.println(prodTotal);

        final Integer result = subsList.stream().map(Subs::getProdList).map(subsProds -> subsProds.stream().map(SubsProd::getProdNum).reduce(0, Integer::sum)).reduce(0, Integer::sum);
        System.out.println(result);
    }


    public static List<Subs> getSubsList() {
        List<Subs> subsList = new ArrayList<>();
        Subs subs1 = new Subs();
        subs1.setSubsId(1);
        List<SubsProd> subsProdList1 = new ArrayList<>();
        SubsProd subsProd_1_1 = new SubsProd();
        subsProd_1_1.setProdNum(1);
        subsProdList1.add(subsProd_1_1);
        SubsProd subsProd_1_2 = new SubsProd();
        subsProd_1_2.setProdNum(2);
        subsProdList1.add(subsProd_1_2);
        subs1.setProdList(subsProdList1);
        subsList.add(subs1);
        Subs subs2 = new Subs();
        subs2.setSubsId(2);
        List<SubsProd> subsProdList2 = new ArrayList<>();
        SubsProd subsProd_2_1 = new SubsProd();
        subsProd_2_1.setProdNum(3);
        subsProdList2.add(subsProd_2_1);
        SubsProd subsProd_2_2 = new SubsProd();
        subsProd_2_2.setProdNum(4);
        subsProdList2.add(subsProd_2_2);
        subs2.setProdList(subsProdList2);
        subsList.add(subs2);

        return subsList;
    }
}
