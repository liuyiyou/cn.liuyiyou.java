/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.thread.Thread1.java
 * 日期: 2017年8月9日下午10:38:57
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java.thread;

/**
 * @author liuyiyou.cn
 * @date 2017年8月9日 下午10:38:57
 * @version
 */
public class Thread1 extends Thread {

	private String name;

	public Thread1(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "运行  :  " + i);
			try {
				sleep((int) Math.random() * 10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		Thread1 mTh1 = new Thread1("A");
		Thread1 mTh2 = new Thread1("B");
		mTh1.start();
		mTh2.start();

	}
}
