/**
 * 所属项目:cn.liuyiyou.common
 * 文件名称:cn.liuyiyou.common.model.Comment.java
 * 日期: 2017年10月13日下午5:31:38
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 *
 */
package cn.liuyiyou.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author liuyiyou.cn
 * @date 2017年10月13日 下午5:31:38
 * @version
 */
@Data
@Accessors(chain = true)
public class Prod {

	private int id;
	private String prodName;
	private double price;
	private boolean status;
	private Date createDate;
	private Date updateDate;
}
