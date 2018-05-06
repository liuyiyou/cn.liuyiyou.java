/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java.language.EaualsTest.java
 * 日期: 2017年8月8日下午6:07:31
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.java.lang;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuyiyou.cn
 * @date 2017年8月8日 下午6:07:31
 * @version
 */
public class EaualsTest {

	public static void main(String[] args) {
		Object a = new Object();
		Object b = new Object();
		System.out.println(a == b); // false
		System.out.println(a.equals(b)); // false
		System.out.println("=============");
		
		
		Object aa = new Object();
		Object bb = aa;
		System.out.println(aa == bb); // true
		System.out.println(aa.equals(bb)); // true
		System.out.println("=============");

		Integer a1 = 1;
		Integer b1 = 1;
		System.out.println(a1 == b1); // true
		System.out.println(a1.equals(b1)); // true
		System.out.println("=============");

		Map a2 = new HashMap();
		Map b2 = new HashMap();
		System.out.println(a2 == b2); // false
		System.out.println(a2.equals(b2)); // true
		System.out.println("=============");

		String a3 = "Hello";
		String b3 = "Hello";
		System.out.println(a3 == b3);
		System.out.println(a3.equals(b3));

		int a4 = 1;
		Integer b4 = 1;
		System.out.println(a4 == b4);
		System.out.println(b4.equals(a4));

		User a5 = new User();
		User b5 = new User();
		System.out.println(a5 == b5);
		System.out.println(a5.equals(b5));

		User a6 = new User(1, "lyy");
		User b6 = a6;
		System.out.println(a6 == b6);
		System.out.println(a6.equals(b6));
		
		User a7 = new User(1, "lyy");
		User b7 = new User(1, "lyy");
		System.out.println(a7 == b7);
		System.out.println(a7.equals(b7));
		

	}

}

class User {
	private int id;
	private String name;

	public User() {
		super();
	}

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
