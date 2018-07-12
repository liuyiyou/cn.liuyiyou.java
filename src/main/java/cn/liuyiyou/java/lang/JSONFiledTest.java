package cn.liuyiyou.java.lang;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/***
 * @author: liuyiyou
 * @date: 2018/5/6
 */
public class JSONFiledTest {

    public static void main(String[] args) {

        List<Refund> refunds =new ArrayList<>();
        Refund refund = new Refund();
        refund.setRefundId("1");
        refund.setName("A");
        refunds.add(refund);
        refund = new Refund();
        refund.setRefundId("2");
        refund.setName("B");
        refunds.add(refund);

        System.out.println(JSON.toJSONString(refunds));

        Result result = new Result();
        result.setTotalResult(10L);
        result.setRefunds(refunds);

        System.out.println(JSON.toJSONString(result));
    }

}

class Refund implements Serializable{

    @JSONField(name = "RefundId",label = "Y")
    private String RefundId;
    @JSONField(name = "Name",label = "Y")
    private String Name;

    public String getRefundId() {
        return RefundId;
    }

    public void setRefundId(String refundId) {
        RefundId = refundId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

class Result implements Serializable{
    @JSONField(name = "TotalResult", label = "Y")
    private Long totalResult;
    @JSONField(name = "Refunds", label = "Y")
    private List<Refund> Refunds;

    public Long getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Long totalResult) {
        this.totalResult = totalResult;
    }

    public List<Refund> getRefunds() {
        return Refunds;
    }

    public void setRefunds(List<Refund> refunds) {
        Refunds = refunds;
    }
}
