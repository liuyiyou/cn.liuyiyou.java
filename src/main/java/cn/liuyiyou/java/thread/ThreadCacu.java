/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.thread.ThreadCacu.java
 * 日期: 2017年8月19日下午11:20:33
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * eg:10个线程，每个线程计算n~n+10的和，最后统计结果
 * 
 * @author liuyiyou.cn
 * @date 2017年8月19日 下午11:20:33
 * @version
 */
public class ThreadCacu {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int totalSum = 0;
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			CacuRunnable r = new CacuRunnable(1000 * i + 1, i);
			Future<Integer> result = executorService.submit(r);
			totalSum += result.get();
		}
		System.out.println(totalSum);
		System.out.println(55 + 155 + 255 + 355 + 455 + 555 + 655 + 755 + 855 + 955);
		executorService.shutdown();
	}

}

class CacuRunnable implements Callable<Integer> {

	private int n;
	private int id;

	public CacuRunnable(int n, int id) {
		super();
		this.n = n;
		this.id = id;
		System.out.println(id);
	}

	@Override
	public Integer call() throws Exception {
		int sum = 0;
		System.out.println("计算" + n + "~" + (n + 1000 - 1) + "的值");
		for (int i = 0; i < 1000; i++) {
			sum += n;
			n++;
		}
		System.out.println(sum);
		return sum;
	}

}
