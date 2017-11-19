/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java8.lambda.CalculatorMain.java
 * 日期: 2017年10月17日下午5:59:42
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java8.lambda;

import java.util.Comparator;
import java.util.function.BooleanSupplier;

/**
 * @author liuyiyou.cn
 * @date 2017年10月17日 下午5:59:42
 * @version
 */
public class CalculatorMain {

	public static void main(String[] args) {

		// 隐式lambda表达式
		MyIntegerCalculator myIntegerCalculator = (Integer s1) -> s1 * 2;
		System.out.println("1- Result x2 : " + myIntegerCalculator.calcIt(5));

		// 显式lambda表达式
		MyIntegerCalculator myIntegerCalculator2 = (s1) -> s1 * 2;
		System.out.println("1- Result x2 : " + myIntegerCalculator2.calcIt(5));

		BooleanSupplier bs = () -> true;
		System.out.println(bs.getAsBoolean());

		int x = 0, y = 1;
		bs = () -> x > y;
		System.out.println(bs.getAsBoolean());

		Printer printer = (String msg) -> {
			System.out.println(msg);
		};
		printer.print("Print");

		Printer printer2 = (String msg) -> System.out.println(msg);
		printer2.print("Print2");
		
		
		Comparator<String> c = (s1, s2) -> s1.compareToIgnoreCase(s2);


	}
}

interface MyIntegerCalculator {
	public Integer calcIt(Integer s1);
	// public Double calcDb(Double d2); //只能有一个方法

}

interface Printer {
	public void print(String msg);
	// public Double calcDb(Double d2); //只能有一个方法

}