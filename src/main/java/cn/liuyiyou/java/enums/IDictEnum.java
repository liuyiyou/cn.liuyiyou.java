/** 
 * Project Name:cn.liuyiyou.java 
 * File Name:IDictEnum.java 
 * Package Name:cn.liuyiyou.java.enums 
 * Date:2017年7月25日下午4:11:49 
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved. 
 * 
 */ 
package cn.liuyiyou.java.enums;


/** 
 * 名称: IDictEnum 枚举的接口定义 <br/> 
 * @author liuyiyou.cn
 * @date 2017年7月25日
 * @version 6.0.0
 */
public interface IDictEnum<T> {

    /**
     * 获取字典键
     * 
     * @return 字典键
     */
    T getKey();

    /**
     * 获取字典值
     * 
     * @return 字典值
     */
    String getValue();

    /**
     * 根据枚举的 key 获取枚举对象
     * @param key 字典键
     * @return 对应的枚举对象，如果没有匹配的枚举对象，则返回 {@code null}
     */
    @SuppressWarnings("unchecked")
    default <R extends IDictEnum<T>> R getByKey(T key) {
        Class<?> clazz = this.getClass();
        if (!clazz.isEnum()) {
            throw new UnsupportedOperationException("类 [" + clazz.getName() + "] 不是枚举，不支持该操作");
        }

        T enumKey;
        IDictEnum<T>[] consts = (IDictEnum<T>[]) clazz.getEnumConstants();
        for (IDictEnum<T> e : consts) {
            enumKey = e.getKey();
            if ((key == null && enumKey == null) || (key != null && key.equals(enumKey))) {
                return (R) e;
            }
        }
        return null;
    }
}

