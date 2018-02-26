/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.language.AddTest.java
 * 日期: 2017年8月5日下午3:51:13
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java.base;

/**
 * @author liuyiyou.cn
 * @date  2017年8月5日 下午3:51:13 
 * @version  
 */
public class AddTest {

	public static void main(String[] args){
		int i = 999;
		System.out.println(i--);
		System.out.println(i);
		++i;
		System.out.println(i);
	}
	
	public  double  add(byte a, double b){
		return a/b*10;
	}
}
