/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java8.DefaultInterface.java
 * 日期: 2017年9月21日上午10:07:44
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java8;

import java.util.function.Supplier;

import org.junit.Test;

/**
 * @author liuyiyou.cn
 * @date 2017年9月21日 上午10:07:44
 * @version
 */
public class DefaultInterface {

	@Test
	public void test() {
		IUserService u = new UserService();
		u.defaultMethod();

		IUserService.create(UserService::new);
	}
}

interface IUserService {

	static IUserService create(Supplier<IUserService> supplier) {
		return supplier.get();
	}

	default void defaultMethod() {
		System.out.println("default method");
	}

	void otherMtheod();
}

class UserService implements IUserService {

	@Override
	public void otherMtheod() {
		System.out.println("otherMeht");
	}

}