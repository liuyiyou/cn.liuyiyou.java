package cn.liuyiyou.java.base;

import lombok.Data;
import lombok.experimental.Accessors;
import org.junit.Test;

/**
 * Java基本数据类型
 *
 * @author: liuyiyou.cn
 * @date: 2019/6/4
 * @version: V1.0
 */
@Data
@Accessors(chain = true)
public class DataTypeExample {
    boolean _boolean;
    byte _byte;
    short _short;
    int _int;
    long _long;
    float _float;
    double _double;
    char _char;

    /**
     * 初始化值
     */
    @Test
    public void initTest() {
        System.out.println(_boolean);
        System.out.println(_byte);
        System.out.println(_short);
        System.out.println(_int);
        System.out.println(_long);
        System.out.println(_float);
        System.out.println(_double);
        System.out.println(_char);
    }

    /**
     * 字节占比
     */
    @Test
    public void byteTest() {
        // 1
        System.out.println(Byte.BYTES);
// 2
        System.out.println(Character.BYTES);
        String cnWorldStr = "中";
// 3 ： utf-8
        System.out.println(cnWorldStr.getBytes().length);
// 4
        System.out.println(Integer.BYTES);
// 4
        System.out.println(Float.BYTES);
// 8
        System.out.println(Double.BYTES);
    }

    /**
     * 取值范围
     */
    @Test
    public void valueRange() {
        System.out.println(Boolean.FALSE + "-" + Boolean.TRUE);
        //-2的7次方到2的7次方-1
        System.out.println(Byte.MIN_VALUE + "-" + Byte.MAX_VALUE);
        System.out.println(Character.MIN_VALUE + "-" + Character.MAX_VALUE);
        //-2的31次方到2的31次方-1
        System.out.println(Integer.MIN_VALUE + "-" + Integer.MAX_VALUE);
        //-2的31次方到2的31次方-1
        System.out.println(Long.MIN_VALUE + "-" + Long.MAX_VALUE);
        //-2的149到2的149次方-1
        System.out.println(Float.MIN_VALUE + "-" + Float.MAX_VALUE);
        //-2的1074次方到2的1074方-1
        System.out.println(Double.MIN_VALUE + "-" + Double.MAX_VALUE);
    }

}
