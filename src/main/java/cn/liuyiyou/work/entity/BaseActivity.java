package cn.liuyiyou.work.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseActivity implements Serializable {
    public static final Byte STATUS_WAITING_START = 0; //未开始
    public static final Byte STATUS_STARTED = 1; //开始
    public static final Byte STATUS_OFF = 2;//结束
    public static final Byte STATUS_PRE_DONE = 3;//预处理


    /**
     * 活动商品适用人群
     */
    public static final Byte APPLICABLE_PEOPLE_ALL = 0;

    public static final Byte APPLICABLE_PEOPLE_C = 1;

    public static final Byte APPLICABLE_PEOPLE_M = 2;

    /**
     * 强制停止的停止状态
     */
    public static final Byte STATUS_FORCE_STOPED = 4;//强制终止

    /**
     * 秒杀
     */
    public static final Byte TYPE_1 = 1;

    /**
     * 福利
     */
    public static final Byte TYPE_2 = 2;

    /**
     * 满减
     */
	/*
	public static  final Byte TYPE_3 = 3;*/

    /**
     * 促销活动，满减和任选的类型都为3
     */
    public static final Byte TYPE_3 = 3;

    /**
     * 限时抢购
     */
    public static final Byte TYPE_4 = 4;

    /**
     * 首单优惠
     */
    public static final Byte TYPE_5 = 5;

    /**
     * 0利润
     */
    public static final Byte TYPE_6 = 6;

    /**
     * 店主权益配置
     */
    public static final Byte TYPE_7 = 7;

    /**
     * 店主升级礼包
     */
    public static final Byte TYPE_8 = 8;

    /**
     * 优惠券活动
     */
    public static final Byte TYPE_9 = 9;
    /**
     * 线下推广
     */
    public static final Byte TYPE_10 = 10;

    /**
     * 任选活动(占坑,任选活动实际使用的是baseActivity里config的type 11)
     */
//	public static final Byte TYPE_11 = 11;

    /**
     * 福利专区
     */
    public static final Byte TYPE_12 = 12;
    /**
     * 折扣活动(占坑,折扣活动实际使用的是baseActivity里config的type 13)
     */
//	public static final Byte TYPE_13 = 13;
    private Long id;


    private String k;

    private Byte type;

    private String name;

    private Date createTime;

    private Date preTime;

    private Date startTime;

    private Date endTime;

    private String desc;

    private Byte status;

    private String channel;

    private String config;

    private String code;

    private Integer weight;

    private transient Byte[] statusArray;

    private transient Byte[] typeArray;

    private Byte putStatus;//上架状态

    private String orderBy;

    public Byte[] getTypeArray() {
        return typeArray;
    }

    public void setTypeArray(Byte[] typeArray) {
        this.typeArray = typeArray;
    }

    private Long intervalTime;

    public Long getIntervalTime() {
        return intervalTime;
    }

    public void setIntervalTime(Long intervalTime) {
        this.intervalTime = intervalTime;
    }


    private static final long serialVersionUID = 1L;



}