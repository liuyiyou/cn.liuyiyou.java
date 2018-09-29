/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java8.groupby.GroupByTest.java
 * 日期: 2017年11月8日上午8:50:26
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java8.groupby;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import cn.liuyiyou.model.SubsProd;
import org.junit.Test;

/**
 * @author liuyiyou.cn
 * @date 2017年11月8日 上午8:50:26
 * @version
 */
public class GroupByTest {

	@Test
	public void sortTest() {
		List<SubsProd> subsProds = getSubsProds();
		subsProds.parallelStream().sorted(Comparator.comparing(SubsProd::getId)).collect(Collectors.toList())
				.forEach(subsProd -> System.out.println(subsProd.getId()));

	}

	@Test
	public void groupByTest() {
		List<SubsProd> subsProds = getSubsProds();
		Map<Long, List<SubsProd>> actSubsProds = subsProds.parallelStream()
				.collect(Collectors.groupingBy(SubsProd::getActId));
		for (Long key : actSubsProds.keySet()) {
			List<SubsProd> prods = actSubsProds.get(key);
			for (SubsProd p : prods) {
				System.out.println(p.getActId() + "\t" + p.getProdName() + "\t");
			}
			System.out.println("--------------------");
		}
	}

	public static List<SubsProd> getSubsProds() {
		List<SubsProd> subsProds = new ArrayList<>();
		SubsProd s1 = new SubsProd();
		s1.setId(1);
		s1.setProdName("1");
		s1.setActId(1L);
		SubsProd s2 = new SubsProd();
		s2.setId(2);
		s2.setActId(2L);
		s2.setProdName("2");
		SubsProd s3 = new SubsProd();
		s3.setId(3);
		s3.setActId(1L);
		s3.setProdName("3");
		SubsProd s4 = new SubsProd();
		s4.setId(4);
		s4.setActId(2L);
		s4.setProdName("4");
		SubsProd s5 = new SubsProd();
		s5.setId(5);
		s5.setActId(1L);
		s5.setProdName("5");
		SubsProd s6 = new SubsProd();
		s6.setId(6);
		s6.setActId(3L);
		s6.setProdName("6");
		subsProds.add(s1);
		subsProds.add(s3);
		subsProds.add(s2);
		subsProds.add(s5);
		subsProds.add(s4);
		subsProds.add(s6);
		return subsProds;
	}

}

