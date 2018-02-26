/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.language.JVMVersion.java
 * 日期: 2017年8月9日下午10:05:41
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 */
package cn.liuyiyou.java.base;

/**
 * @author liuyiyou.cn
 * @date 2017年8月9日 下午10:05:41
 * @version
 */
public class JVMVersion {

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.arch"));
        System.out.println(Runtime.getRuntime().freeMemory());
    }
}
