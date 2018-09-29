package cn.liuyiyou.third;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_DOWN;
import static java.math.BigDecimal.ROUND_HALF_DOWN;
import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * Created by IBA-EDV on 2018/3/16.
 */
public class BigDecimalUtil {

    private BigDecimalUtil(){};

    //默认运算精度
    private static final int DEF_DIV_SCALE = 8;
    private static final int UP = ROUND_HALF_UP;
    private static final int DOWN = ROUND_HALF_DOWN;

    /**
     * 提供精确加法计算的add方法
     * @param value1 被加数
     * @param value2 加数
     * @return 两个参数的和
     */
    public static Float add(Float value1,Float value2) throws IllegalArgumentException {
        validateParmsNotNull(value1, value2);
        return new BigDecimal(value1.toString()).add(new BigDecimal(value2.toString())).floatValue();
    }

    /**
     * 提供精确减法运算的sub方法
     * @param value1 被减数
     * @param value2 减数
     * @return 两个参数的差
     */
    public static Float sub(Float value1,Float value2) throws IllegalArgumentException {
        validateParmsNotNull(value1, value2);
        return new BigDecimal(value1.toString()).subtract(new BigDecimal(value2.toString())).floatValue();
    }

    /**
     * 提供精确乘法运算的mul方法
     * 小数点以后10位，以后的数字四舍五入。
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    public static Float mul(Float value1,Float value2) throws IllegalArgumentException {
        return mul(value1, value2, DEF_DIV_SCALE);
    }

    /**
     * 提供精确乘法运算的mul方法
     * @param value1 被乘数
     * @param value2 乘数
     * @return 两个参数的积
     */
    private static Float mul(Float value1,Float value2,int scale) throws IllegalArgumentException {
        validateParmsNotNull(value1, value2);
        return new BigDecimal(value1.toString()).multiply(new BigDecimal(value2.toString()))
                .setScale(scale, ROUND_HALF_UP).floatValue();
    }


    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入。
     * @param value1 被除数
     * @param value2 除数
     * @return 两个参数的商
     */

    public static Float div(Float value1,Float value2) throws IllegalArgumentException {
        return div(value1, value2,DEF_DIV_SCALE);
    }

    /**
     * 提供精确的除法运算方法div
     * @param value1 被除数
     * @param value2 除数
     * @param scale 精确范围
     * @return 两个参数的商
     * @throws IllegalArgumentException
     */
    private static Float div(Float value1,Float value2,int scale) throws IllegalArgumentException{
        //如果精确范围小于0，抛出异常信息
        if(scale < 0){
            throw new IllegalArgumentException("精确度不能小于0");
        }
        validateParmsNotNull(value1, value2);
        if (value2.equals(0)){
            throw new IllegalArgumentException("被除数不能为0!");
        }
        return new BigDecimal(value1.toString())
                .divide(new BigDecimal(value2.toString()), scale, ROUND_HALF_UP).floatValue();
    }



    /**
     * 提供精确的小数位四舍五入处理。
     * @param value 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static Float round(Float value, int scale) {
        return round(value,scale,true);
    }


    /**
     * 提供精确的小数位四舍五入处理。
     * @param value 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @param type true 四舍五入 false 则不四舍五入小数
     * @return 四舍五入后的结果
     */
    public static Float round(Float value, int scale, boolean type) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        if (value == null){
            throw new IllegalArgumentException("参数不能为空!");
        }

        return new BigDecimal(value.toString()).divide(
                new BigDecimal("1"), scale, type ? ROUND_HALF_UP : ROUND_DOWN ).floatValue();
    }

    private static void validateParmsNotNull(Float value1, Float value2) throws IllegalArgumentException {
        if (value1 == null || value2 == null){
            throw new IllegalArgumentException("参数不能为空!");
        }
    }

    public static void main(String[] args) throws IllegalArgumentException {
        Float add = add(1.023F, 2.027F);
        System.out.println(add);//3.05

        Float sub = sub(1.023F, 2.027F);
        System.out.println(sub);// -1.004

        Float mul = mul(1.0033022F, 2F);
        System.out.println(mul);//2.0066001
        System.out.println(round(mul,4));//2.0066

        Float div = div(8.8888008F, 1.1F);
        System.out.println(div);
        System.out.println(round(div,2));
        System.out.println(round(div,4,false));
    }
}