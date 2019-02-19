/**
 * 所属项目:cn.liuyiyou.common
 * 文件名称:cn.liuyiyou.common.utils.User.java
 * 日期: 2017年10月13日下午5:31:17
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;


/**
 * @author liuyiyou.cn
 * @date  2017年10月13日 下午5:31:17 
 * @version  
 */
@Data
@Accessors(chain = true)
public class User {

	private int id;
	private String userName;
	private String mobile;
	private Date createDate;
	private Date updateDate;
	private Address address;
}
