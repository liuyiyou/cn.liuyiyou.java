/** 
 * Project Name:cn.liuyiyou.java 
 * File Name:MyThread.java 
 * Package Name:cn.liuyiyou.java.juc.concurrent
 * Date:2017年7月25日下午2:31:07 
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved. 
 * 
 */
package cn.liuyiyou.java.juc.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 名称: MyThread <br/>
 * 
 * @author liuyiyou.cn
 * @date 2017年7月25日
 * @version 6.0.0
 */
public class MyThread implements Runnable {
	String name;

	CountDownLatch latch;

	MyThread(CountDownLatch c, String n) {
		latch = c;
		name = n;
		System.out.println(n);
		new Thread(this);
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			latch.countDown();
		}
	}
}
