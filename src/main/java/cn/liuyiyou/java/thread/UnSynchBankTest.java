/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.thread.Bank.java
 * 日期: 2017年8月19日下午10:32:53
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java.thread;

/**
 * @author liuyiyou.cn
 * @date 2017年8月19日 下午10:32:53
 * @version
 */
public class UnSynchBankTest {

	static final int MACCOUNTS = 100;
	static final double INITIAL_BALANCE = 1000;

	public static void main(String[] args) {
		Bank b = new Bank(MACCOUNTS, INITIAL_BALANCE);
		for (int i = 0; i < MACCOUNTS; i++) {
			TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}
}

class Bank {

	private final double[] accounts;

	public Bank(int n, double initBanlance) {
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initBanlance;
		}
	}

	public void transfer(int from, int to, double amount) {
		if (accounts[from] < amount) {
			return;
		}
		System.out.println(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf("  %10.2f from %d to %d", amount, from, to);
		accounts[to] += amount;
		System.out.printf("  总额为:%10.2f%n", getTotalBanance());
	}

	public int size() {
		return accounts.length;
	}

	public double getTotalBanance() {
		double sum = 0;
		for (double a : accounts) {
			sum += a;
		}
		return sum;
	}
}

class TransferRunnable implements Runnable {

	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 10;

	/**
	 * 
	 */
	public TransferRunnable(Bank bank, int fromAccount, double maxAmount) {
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
