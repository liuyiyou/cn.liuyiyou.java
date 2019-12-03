/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.jvm.HeapOOP.java
 * 日期: 2017年8月19日下午8:03:29
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.book.jvm.ch02;

import java.util.ArrayList;
import java.util.List;

/**
 * OutOfMemoryException
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * @author liuyiyou.cn
 * @date  2017年8月19日 下午8:03:29 
 * @version  
 */
public class HeapOOP {

	static class OOMObject{}
	
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(5000L);
		List<OOMObject> list = new ArrayList<>();
		while(true){
			list.add(new OOMObject());
		}
	}
}
