package cn.liuyiyou.java.lang;

import cn.liuyiyou.model.SubsProd;

/**
 * @author: liuyiyou.cn
 * @date: 2019/5/6
 * @version: V1.0
 */
public class ObjectTansmit {

    //对象传递后是否有变化
    public static void wrapSomething(SubsProd subsProd){
        subsProd.setProdName("addProdName");
    }

    public static void main(String[] args) {
        SubsProd subsProd =new SubsProd();
        subsProd.setId(1);
        subsProd.setActId(1L);
        System.out.println(subsProd);
        wrapSomething(subsProd);
        System.out.println(subsProd);
    }
}
