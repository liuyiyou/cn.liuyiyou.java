/** 
 * Project Name:cn.liuyiyou.java 
 * File Name:BillStatus.java 
 * Package Name:cn.liuyiyou.java.enums 
 * Date:2017年7月25日下午4:12:44 
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved. 
 * 
 */ 
package cn.liuyiyou.java.enums;


/** 
 * 名称: BillStatus <br/> 
 * @author liuyiyou.cn
 * @date 2017年7月25日
 * @version 6.0.0
 */
public enum BillStatus implements IIntegerDictEnum {

	/** 待支付状态 */
	PENGDING_TREATMENT(0, "待支付"),

	/** 1:对账中 */
	IN_TREATMENT(1, "对账中"),

	/** 对账成功后的状态 */
	COMPLETED(2, "对账成功"),

	/** 对账失败后的状态 */
	CLOSED(3, "已关闭"),

	/** 对账失败 */
	CHECK_FAILD(5, "对账失败"),

	/** 退款处理中 */
	REFUNDING(8, "退款处理中"),

	/** 已退款 */
	REFUNDED(9, "已退款");

	public static final String DNAME = "bill-status";

	public final Integer key;
	public final String value;

	private BillStatus(int key, String value) {
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