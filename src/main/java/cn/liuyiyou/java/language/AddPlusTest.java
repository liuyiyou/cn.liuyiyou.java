/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.language.AddPlusTest.java
 * 日期: 2017年8月20日下午10:00:26
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java.language;

/**
 * @author liuyiyou.cn
 * @date 2017年8月20日 下午10:00:26
 * @version
 */
public class AddPlusTest {

	public static void main(String[] args) {
		int m = 7;
		int n = 7;
		System.out.println(2 * ++m); // 2*8
		System.out.println(2 * n++); // 2*7
		System.out.println(2 * (n++));// 2*8
	}
}
