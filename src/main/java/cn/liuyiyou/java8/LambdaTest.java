/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java8.LambdaTest.java
 * 日期: 2017年9月21日上午10:03:54
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java8;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author liuyiyou.cn
 * @date 2017年9月21日 上午10:03:54
 * @version
 */
public class LambdaTest {

	@Test
	public void test1() {
		Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));

		Arrays.asList("a", "b", "c").forEach(e -> {
			System.out.println(e);
			System.out.println(e);
		});
	}

	@Test
	public void test2() {
		Runnable runnable = () -> {
			System.out.println("xxx");
		};
	}

	public int add(int x, int y) {
		return x + y;
	}

}
