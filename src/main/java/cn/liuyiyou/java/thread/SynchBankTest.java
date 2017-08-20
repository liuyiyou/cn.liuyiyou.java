/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.thread.Bank.java
 * 日期: 2017年8月19日下午10:32:53
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liuyiyou.cn
 * @date 2017年8月19日 下午10:32:53
 * @version
 */
public class SynchBankTest {

	static final int MACCOUNTS = 100;
	static final double INITIAL_BALANCE = 1000;

	public static void main(String[] args) {
		Bank2 b = new Bank2(MACCOUNTS, INITIAL_BALANCE);
		for (int i = 0; i < MACCOUNTS; i++) {
			TransferRunnable2 r = new TransferRunnable2(b, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}
}

class Bank2 {

	private final double[] accounts;

	// 构建一个可被用来保护临街区的可重入锁
	private Lock bankLock;

	private Condition sufficientFunds;

	public Bank2(int n, double initBanlance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initBanlance;

		}
		bankLock = new ReentrantLock();
		//返回该锁相关的一个条件对象
		sufficientFunds = bankLock.newCondition();
	}

	public void transfer(int from, int to, double amount) throws InterruptedException {
		// 获取这个锁，如果该锁被其他线程持有，则发送阻塞
		bankLock.lock();
		try {
			if (accounts[from] < amount) {
				//把该线程放到条件的等待集中
				sufficientFunds.await();
				// 之前是return
			}
			System.out.println(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf("  %10.2f from %d to %d", amount, from, to);
			accounts[to] += amount;
			System.out.printf("  总额为:%10.2f%n", getTotalBanance());
			//解除该条件等待集中所有线程的阻塞状态
			sufficientFunds.signalAll();
		} finally {
			// 释放这个锁
			bankLock.unlock();
		}
	}

	public int size() {
		return accounts.length;
	}

	public double getTotalBanance() {
		bankLock.lock();
		try {
			double sum = 0;
			for (double a : accounts) {
				sum += a;
			}
			return sum;
		} finally {
			bankLock.unlock();
		}
	}
}

class TransferRunnable2 implements Runnable {

	private Bank2 bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 10;

	/**
	 * 
	 */
	public TransferRunnable2(Bank2 bank, int fromAccount, double maxAmount) {
		this.bank = bank;
		this.fromAccount = fromAccount;
		this.maxAmount = maxAmount;

	}

	@Override
	public void run() {
		try {
			while (true) {
				int toAccount = (int) (bank.size() * Math.random());
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int) (DELAY * Math.random()));
			}

		} catch (InterruptedException e) {
			e.getMessage();
		}
	}

}
