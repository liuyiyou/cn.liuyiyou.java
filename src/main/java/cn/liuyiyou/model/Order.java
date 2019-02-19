package cn.liuyiyou.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;


/**
 * @author liuyiyou.cn
 * @date 2017年10月13日 下午5:30:51
 * @version
 */
@Data
@Accessors(chain = true)
public class Order {

    private int id;
    private String orderNo;
    private List<Prod> prods;
    private Date createDate;
    private Date updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
