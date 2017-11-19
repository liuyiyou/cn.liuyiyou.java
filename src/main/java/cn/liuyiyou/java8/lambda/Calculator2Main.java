/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java8.lambda.Calculator2Main.java
 * 日期: 2017年10月18日上午8:36:56
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java8.lambda;

/**
 * @author liuyiyou.cn
 * @date 2017年10月18日 上午8:36:56
 * @version
 */
public class Calculator2Main {

	public static void main(String[] args) {
		engin((x, y) -> x + y);
		engin((x, y) -> x - y);
		engin((x, y) -> x * y);
		engin((x, y) -> x / y);
		engin((x, y) -> x % y);

		engin((x, y) -> x + y, 2, 4);
		engin((x, y) -> x - y, 2, 4);
		engin((x, y) -> x * y, 2, 4);
		engin((x, y) -> x / y, 2, 4);
		engin((x, y) -> x % y, 2, 4);
	}

	private static void engin(Caculator caculator) {
		int x = 2, y = 4;
		int result = caculator.caculator(x, y);
		System.out.println(result);
	}

	private static void engin(Caculator caculator, int x, int y) {
		int result = caculator.caculator(x, y);
		System.out.println(result);
	}
}

interface Caculator {
	int caculator(int x, int y);
}
