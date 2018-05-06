/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.swith.SwitchTest.java
 * 日期: 2017年10月20日下午4:04:51
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 */
package cn.liuyiyou.java.swith;

/**
 * @author liuyiyou.cn
 * @date 2017年10月20日 下午4:04:51
 * @version
 */
public class SwitchTest {

    public static void main(String[] args) {
        switchNoBreak(1);
        switchOneBreak(1);
    }


    /**
     * 没有break，会继续执行，一直到有break为止
     * @param i
     */
    public static void switchNoBreak(int i) {
        switch (i) {
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
            case 3:
                System.out.println(3);
            default:
                System.out.println(4);
        }
    }


    public static void switchOneBreak(int i) {
        switch (i) {
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println(3);
                break;
            default:
                System.out.println(4);
        }
    }


}
