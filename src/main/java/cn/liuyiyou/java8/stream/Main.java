/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java8.stream.Main.java
 * 日期: 2017年10月18日上午8:49:58
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java8.stream;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import org.junit.Test;

/**
 * @author liuyiyou.cn
 * @date 2017年10月18日 上午8:49:58
 * @version
 */
public class Main {

	/**
	 * 对数组中的奇数求平方和 1+9+25
	 */
	@Test
	public void beforeJava8() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		int sum = 0;
		for (int n : numbers) {
			if (n % 2 == 1) {
				int square = n * n;
				sum = sum + square;
			}
		}
		assertEquals(sum, 35);
	}

	@Test
	public void onJava8() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		int sum = numbers.stream().filter(n -> n % 2 == 1).map(n -> n * n).reduce(0, Integer::sum);
		assertEquals(sum, 35);
	}

	@Test
	public void onJava8_2() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		int sum = numbers.parallelStream().filter(n -> n % 2 == 1).map(n -> n * n).reduce(0, (a, b) -> a + b);
		assertEquals(sum, 35);
	}
	
	@Test
	public void onJava8_3() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		long count = numbers.parallelStream().filter(n -> n % 2 == 1).count();
		assertEquals(count, 3);
	}
	
	@Test
	public void onJava8_4() {
		List<Integer> numbers = Arrays.asList();
		long count = numbers.parallelStream().filter(n -> n % 2 == 1).count();
		assertEquals(count, 0);
	}


	@Test
	public void test1(){
		List<Integer> nums = Lists.newArrayList(1,null,3,4,null,6);
		//过滤
		long count = nums.stream().filter(num -> num != null).count();
		System.out.println(count);



		Stream<Integer> integerStream = Stream.of(1,null,3,4,null,6);
		long count2 = nums.stream().filter(num -> num != null).count();
		System.out.println(count2);


		Stream.generate(new Supplier<Double>() {
			@Override
			public Double get() {
				return Math.random();
			}
		});
		Stream.generate(() -> Math.random());
		Stream.generate(Math::random);

		Stream.generate(() -> "1111".length());
	}

}
