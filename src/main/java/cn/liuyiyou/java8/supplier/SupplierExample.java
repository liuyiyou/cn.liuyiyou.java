package cn.liuyiyou.java8.supplier;

import org.junit.Test;

import java.util.function.Supplier;

/***
 *
 * Supplier字面上的意思是供应商
 * @author: liuyiyou.cn
 * @date: 2018/10/23
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
public class SupplierExample {

    @Test
    public void test1() {
        Supplier<String> i = () -> "java2s.com";
        System.out.println(i.get());
    }
}
