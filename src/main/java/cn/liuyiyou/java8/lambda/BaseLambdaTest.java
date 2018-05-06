/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java8.lambda.BaseLambdaTest.java
 * 日期: 2017年10月17日下午5:43:40
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java8.lambda;

import org.junit.Test;

/**
 * @author liuyiyou.cn
 * @date 2017年10月17日 下午5:43:40
 * @version
 */
@SuppressWarnings("ALL")
public class BaseLambdaTest {

	@Test
	public void add() {

		/**
		 * 接口方法实现
		 */
		AddClass result = (m, n) -> {
			return m + n;
		};

		/**
		 * 接口方法调用
		 */
		int result2 = result.add(3, 4);
		System.out.println(result2);
	}

}

@FunctionalInterface
interface AddClass {
	/**
	 * 接口方法定义
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	int add(int x, int y);
}
