/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.collection.HashMapTest.java
 * 日期: 2017年8月16日下午8:27:02
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java.collection;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * @author liuyiyou.cn
 * @date 2017年8月16日 下午8:27:02
 * @version
 */
public class HashMapTest {

	@Test
	public void putTest() {
		Map<String, Object> map = new HashMap<>();

		System.err.println(1 << 1);
		System.err.println(2 << 1);
		System.err.println(3 << 3); // 3* 2^3
	}
}
