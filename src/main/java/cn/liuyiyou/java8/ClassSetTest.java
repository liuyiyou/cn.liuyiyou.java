/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java8.ClassSetTest.java
 * 日期: 2017年10月11日下午5:24:21
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 */
package cn.liuyiyou.java8;

/**
 * @author liuyiyou.cn
 * @date 2017年10月11日 下午5:24:21
 * @version
 */
public class ClassSetTest {

    public static void main(String[] args) {
        User user = new User() {{
            setAge(18);
            setName("lyy");
        }};
        System.out.println(user.getName());
    }
}
