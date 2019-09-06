/** 
 * Project Name:cn.liuyiyou.java 
 * File Name:SimpExec.java 
 * Package Name:cn.liuyiyou.java.juc.concurrent
 * Date:2017年7月25日下午2:30:43 
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved. 
 * 
 */
package cn.liuyiyou.java.juc.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**

 * 名称: SimpExec <br/>
 * 
 * @author liuyiyou.cn
 * @date 2017年7月25日
 * @version 6.0.0
 */
public class SimpExec {
	public static void main(String args[]) {
		CountDownLatch cdl = new CountDownLatch(5);
		CountDownLatch cdl2 = new CountDownLatch(5);
		CountDownLatch cdl3 = new CountDownLatch(5);
		CountDownLatch cdl4 = new CountDownLatch(5);
		ExecutorService es = Executors.newFixedThreadPool(2);

		es.execute(new MyThread(cdl, "A"));
		es.execute(new MyThread(cdl2, "B"));
		es.execute(new MyThread(cdl3, "C"));
		es.execute(new MyThread(cdl4, "D"));

		try {
			cdl.await();
			cdl2.await();
			cdl3.await();
			cdl4.await();
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}

		es.shutdown();
	}
}
