/** 
 * Project Name:cn.liuyiyou.java 
 * File Name:Main.java 
 * Package Name:cn.liuyiyou.java.enums 
 * Date:2017年7月25日下午4:13:08 
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved. 
 * 
 */
package cn.liuyiyou.java.enums;

import java.util.Date;

import cn.liuyiyou.common.utils.JsonUtil;

/**
 * 名称: Main <br/>
 * 
 * @author liuyiyou.cn
 * @date 2017年7月25日
 * @version 6.0.0
 */
public class Main {

	public static void main(String[] args) {
		BillType billType = BillType.BANK.getByKey(0);
		System.out.println(billType.getValue());

		switch (billType) {
		case POS:
			System.out.println("POS");
			break;
		case ONLINE:
			System.out.println("ONLINE");
			break;
		case BANK:
			System.out.println("BANK");
			break;
		case SCAN:
			System.out.println("SCAN");
			break;
		default:
			System.out.println("OTHER");
		}

		String json = "{\"id\":1,\"man\":true,\"name\":\"liuyiyiu\",\"birthday\":\"2017-07-25 16:50:20\"}";
		User u = JsonUtil.json2Object(json, User.class);
		System.out.println(u.getName() + "\t" + u.getBirthday());
	}
}

class User {
	private int id;
	private boolean man;
	private String name;
	private Date birthday;

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @param id
	 * @param man
	 * @param name
	 * @param birthday
	 */
	public User(int id, boolean man, String name, Date birthday) {
		super();
		this.id = id;
		this.man = man;
		this.name = name;
		this.birthday = birthday;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isMan() {
		return man;
	}

	public void setMan(boolean man) {
		this.man = man;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", man=");
		builder.append(man);
		builder.append(", name=");
		builder.append(name);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append("]");
		return builder.toString();
	}

}
