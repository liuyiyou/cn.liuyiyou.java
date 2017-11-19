/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java8.test.StreamTest.java
 * 日期: 2017年10月16日上午11:23:07
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java8.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import cn.liuyiyou.java8.model.Prod;

/**
 * @author liuyiyou.cn
 * @date 2017年10月16日 上午11:23:07
 * @version
 */
public class StreamTest {

	@Test
	public void streamCountTest() {
		List<Prod> prods = DataProvider.prodListProvider();
		Assert.assertEquals(prods.stream().count(), prods.size());
	}

	@Test
	public void test1() {
		List<Prod> prods = DataProvider.prodListProvider();
		Assert.assertEquals(prods.stream().filter(prod -> prod.getProdName().equals("IPhone4")).count(), prods.size());
	}

}
