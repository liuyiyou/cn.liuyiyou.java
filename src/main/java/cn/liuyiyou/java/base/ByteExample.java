package cn.liuyiyou.java.base;

import org.junit.Test;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2019/10/31
 * @Copyright 2019 liuyiyou.cn Inc. All rights reserved
 */
public class ByteExample {

    @Test
    public void byteEquals(){
        Byte status = (byte)1;
        System.out.println(status == 1);
        System.out.println(status.equals(Byte.valueOf("1")));
        System.out.println(status.equals(1));
    }
}
