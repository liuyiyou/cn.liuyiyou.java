/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.thread.concurrent.MyCacu.java
 * 日期: 2017年8月5日下午3:48:05
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java.thread.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.collections.set.SynchronizedSet;

/**
 * 一个文件中有10000个数，用Java实现一个多线程程序将这个10000个数输出到5个不用文件中（不要求输出到每个文件中的数量相同）。
 * 要求启动10个线程，两两一组，分为5组。每组两个线程分别将文件中的奇数和偶数输出到该组对应的一个文件中，
 * 需要偶数线程每打印10个偶数以后，就将奇数线程打印10个奇数，如此交替进行。同时需要记录输出进度，
 * 每完成1000个数就在控制台中打印当前完成数量，并在所有线程结束后，在控制台打印”Done”.
 * 
 * @author liuyiyou.cn
 * @date 2017年8月5日 下午3:48:05
 * @version
 */

public class MyCacu {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		int n = 0;
		for (int i = 1; i <= 10000; i++) {
			n += i;
		}
		System.out.println(n);
		int m = 0;
		int sum = 0;
//		for (int i = 1; i <= 10000; i++) {
//			if (i % 2000 == 0) {
//				m++;
//				
//				
//				sum = sum + result.get();
//			}
//		}
//		System.out.println(sum);
		ExecutorService service = Executors.newSingleThreadExecutor();
		Future<Integer> result = service.submit(new Cacu(1, "Thread:" + m));
		Future<Integer> result2 = service.submit(new Cacu(2001, "Thread:" + m));
		Future<Integer> result3 = service.submit(new Cacu(4001, "Thread:" + m));
		Future<Integer> result4 = service.submit(new Cacu(6001, "Thread:" + m));
		Future<Integer> result5 = service.submit(new Cacu(8001, "Thread:" + m));
		System.out.println(result.get()+result2.get()+result3.get()+result4.get()+result5.get());
	}
}

class Cacu implements Callable<Integer> {

	private int sum;
	private String name;

	public Cacu(int sum, String name) {
		this.sum = sum;
		this.name = name;
	}

	@Override
	public Integer call() throws Exception {
		System.out.println(sum);
		for (int i = 1; i <= 2000; i++) {
			sum += i;
		}
		System.out.println("sum::" + sum);
		return sum;
	}

}
