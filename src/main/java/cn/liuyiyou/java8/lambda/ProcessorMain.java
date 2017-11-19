/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java8.lambda.Processor.java
 * 日期: 2017年10月17日上午9:57:44
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java8.lambda;

/**
 * @author liuyiyou.cn
 * @date 2017年10月17日 上午9:57:44
 * @version
 */
public class ProcessorMain {

	public static void main(String[] args) {
		Processor stringProcessor = (str) -> str.length();
		String name = "Java Lambda";
		System.out.println(stringProcessor);
		int length = stringProcessor.getStringLength(name);
		System.out.println(length);
	}
}

/**
 * 函数式接口
 */
@FunctionalInterface
interface Processor {
	int getStringLength(String str);
}