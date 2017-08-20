/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.thread.JoinTest1.java
 * 日期: 2017年8月9日下午10:57:15
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java.thread;

/**
 * @author liuyiyou.cn
 * @date 2017年8月9日 下午10:57:15
 * @version
 */
public class JoinTest1 extends Thread {
	private String name;

	public JoinTest1(String name) {
		super(name);
		this.name = name;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
		for (int i = 0; i < 5; i++) {
			System.out.println("子线程" + name + "运行 : " + i);
			try {
				sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + "主线程运行开始!");
		Thread1 mTh1 = new Thread1("A");
		Thread1 mTh2 = new Thread1("B");
		mTh1.start();
		mTh2.start();
		System.out.println(Thread.currentThread().getName() + "主线程运行结束!");

	}

}
