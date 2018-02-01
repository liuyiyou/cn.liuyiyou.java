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
		map.put(null,"aaa");
		System.out.println(map.get(null));
	}

	@Test
	public void getTest(){
		Map<String,String> userMap = new HashMap<String,String>();
		userMap.put("1", "1");
		System.out.println(userMap.get("1"));  //有对象
		System.out.println(userMap.get(1));  //null

		Map  userMap3 = new HashMap ();
		userMap3.put("1", "1");
		userMap3.put(1, "1");
		System.out.println(userMap3.get("1"));  //有对象
		System.out.println(userMap3.get(1));  //null


		Map<Object,String> userMap2 = new HashMap<Object, String>();
		userMap2.put("1", "1");
		userMap2.put(1, "1");
		System.out.println(userMap2.get("1"));  //1
		System.out.println(userMap2.get(1));  //1
	}
}
