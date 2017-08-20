/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.thread.Thread3.java
 * 日期: 2017年8月9日下午11:04:58
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java.thread;

/**
 * 
 * 多线程计算1~100之和，分为5个线程，每个线程计算20个数 Thread1： 1~20之和 Thread2 21~40 Thread3 41~60
 * Thread4 61~80 Thread5 81~100
 * 
 * @author liuyiyou.cn
 * @date 2017年8月9日 下午11:04:58
 * @version
 */
public class Thread3 implements Runnable {

	int n;
	String name;

	public Thread3(int n, String name) {
		super();
		this.n = n;
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "：运行");
		n = 2*n;
		for (int i = 1; i <= 20; i++) {
			n = n + i;
		}
		System.out.println(n);
	}

	public static void main(String[] args) {
		Thread3 t = new Thread3(0, "a"); // 210
		Thread3 t2 = new Thread3(210, "b");// 420
		Thread3 t3 = new Thread3(420, "c");// 630
		Thread3 t4 = new Thread3(630, "d");// 840
		Thread3 t5 = new Thread3(840, "e");// 1050
//		new Thread(t).start();
		new Thread(t2).start();
		// new Thread(t3).start();
		// new Thread(t4).start();
		// new Thread(t5).start();

		System.out.println("xx:" + (210 + 420 + 630 + 840 + 1050));
	}

}
