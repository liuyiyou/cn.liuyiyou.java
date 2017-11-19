/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java8.test.DataProvider.java
 * 日期: 2017年10月16日上午11:17:25
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java8.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.liuyiyou.java8.model.Prod;

/**
 * @author liuyiyou.cn
 * @date  2017年10月16日 上午11:17:25 
 * @version  
 */
public class DataProvider {
	
	private static List<Prod>  prodList = new ArrayList<>();

	public static List<Prod> prodListProvider(){
		Prod prod = new Prod();
		prod.setId(1);
		prod.setPrice(1421.21);
		prod.setProdName("IPhone4");
		prod.setStatus(true);
		prod.setCreateDate(new Date());
		prod.setUpdateDate(new Date());
		prodList.add(prod);
		
		prod.setId(2);
		prod.setPrice(0.00);
		prod.setProdName("IPhone4s");
		prod.setStatus(true);
		prod.setCreateDate(new Date());
		prod.setUpdateDate(new Date());
		prodList.add(prod);
		
		prod.setId(3);
		prod.setPrice(2313);
		prod.setProdName(null);
		prod.setStatus(true);
		prod.setCreateDate(new Date());
		prod.setUpdateDate(new Date());
		prodList.add(prod);
		
		
		prod.setId(4);
		prod.setPrice(1123);
		prod.setProdName("IPhone6s");
		prod.setStatus(false);
		prod.setCreateDate(new Date());
		prod.setUpdateDate(new Date());
		prodList.add(prod);
		
		
		prod.setId(5);
		prod.setPrice(1123);
		prod.setProdName("IPhone6s");
		prod.setStatus(false);
		prod.setCreateDate(new Date());
		prod.setUpdateDate(new Date());
		prodList.add(prod);
		
		
		prod.setId(1);
		prod.setPrice(11.23);
		prod.setProdName("IPhone6s");
		prod.setStatus(true);
		prod.setCreateDate(new Date());
		prod.setUpdateDate(new Date());
		prodList.add(prod);
		
		prod.setId(1);
		prod.setPrice(11.23);
		prod.setProdName("IPhone6s");
		prod.setStatus(true);
		prod.setCreateDate(new Date());
		prod.setUpdateDate(new Date());
		prodList.add(prod);
		
		prod.setId(1);
		prod.setPrice(11.23);
		prod.setProdName("IPhone6s");
		prod.setStatus(true);
		prod.setCreateDate(new Date());
		prod.setUpdateDate(new Date());
		prodList.add(prod);
		
		prod.setId(1);
		prod.setPrice(11.23);
		prod.setProdName("IPhone6s");
		prod.setStatus(true);
		prod.setCreateDate(new Date());
		prod.setUpdateDate(new Date());
		prodList.add(prod);
		
		prod.setId(1);
		prod.setPrice(11.23);
		prod.setProdName("IPhone6s");
		prod.setStatus(true);
		prod.setCreateDate(new Date());
		prod.setUpdateDate(new Date());
		prodList.add(prod);
		
		prod.setId(1);
		prod.setPrice(11.23);
		prod.setProdName("IPhone6s");
		prod.setStatus(true);
		prod.setCreateDate(new Date());
		prod.setUpdateDate(new Date());
		prodList.add(prod);
		return prodList;
	}
}
