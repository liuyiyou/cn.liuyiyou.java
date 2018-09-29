package cn.liuyiyou.java.lang;

import cn.liuyiyou.third.BigDecimalUtil;
import cn.liuyiyou.third.NumberUtil;

public class JingDuSunShi {


    public static void main(String[] args) {

        Float f1  = 22.4F;
        float f2 = 580F;

        System.out.println((f2-f1));
        Float f = NumberUtil.subtract(f2,f1);
        System.out.println(f*100);

        System.out.println(NumberUtil.multip(NumberUtil.subtract(f2,f1), 100));
        System.out.println(NumberUtil.multip(NumberUtil.subtract(f2,f1), 100).intValue());
        System.out.println(BigDecimalUtil.mul(BigDecimalUtil.sub(f2,f1),100F).intValue());
        System.out.println(String.valueOf(NumberUtil.multip(557.6F, 100).intValue()));
        System.out.println(String.valueOf(NumberUtil.multip(0.6F, 100).intValue()));

        System.out.println(557.6*100); //默认的是double
        System.out.println(NumberUtil.multip(557.6F, 100));

    }
}
