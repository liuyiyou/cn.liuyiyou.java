/** 
 * Project Name:cn.liuyiyou.java 
 * File Name:BillType.java 
 * Package Name:cn.liuyiyou.java.enums 
 * Date:2017年7月25日下午4:13:43 
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved. 
 * 
 */ 
package cn.liuyiyou.java.enums;


/** 
 * 名称: BillType <br/> 
 * @author liuyiyou.cn
 * @date 2017年7月25日
 * @version 6.0.0
 */
public enum BillType implements IDictEnum<Integer> {

	/** 0-POS机支付 */
	POS(0, "POS机支付"),

	/** 1-在线支付 */
	ONLINE(1, "在线支付"),

	/** 2-扫码支付 */
	SCAN(2, "扫码支付"),

	/** 3-银行转账 */
	BANK(3, "银行转账"),

	/** 9-优惠券 */
	COUPON(9, "优惠券");

	public static final String DNAME = "bill-type";

	public final Integer key;
	public final String value;

	private BillType(Integer key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public Integer getKey() {
		return key;
	}

	@Override
	public String getValue() {
		return value;
	}

}

