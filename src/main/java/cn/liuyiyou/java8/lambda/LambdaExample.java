package cn.liuyiyou.java8.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BooleanSupplier;
import java.util.function.IntToDoubleFunction;

/**
 * @author: liuyiyou@liuyiyou.cn
 * @date: 2018/9/21
 * @version: V1.0
 * @Copyright: 2018 liuyiyou.cn Inc. All rights reserved.
 */
public class LambdaExample {

    @Test
    public void test1() {
        IntToDoubleFunction intToDoubleFunction = (int x) -> x + 1;
        double v = intToDoubleFunction.applyAsDouble(2);
        System.out.println(v);
    }

    @Test
    public void test2() {

        // 显式lambda表达式
        MyIntegerCalculator myIntegerCalculator = (Integer s1) -> s1 * 2;
        System.out.println("1- Result x2 : " + myIntegerCalculator.calcIt(5));

        // 隐式lambda表达式
        MyIntegerCalculator myIntegerCalculator2 = (s1) -> s1 * 2;
        System.out.println("1- Result x2 : " + myIntegerCalculator2.calcIt(5));

        BooleanSupplier bs = () -> true;
        System.out.println(bs.getAsBoolean());

        int x = 0, y = 1;
        bs = () -> x > y;
        System.out.println(bs.getAsBoolean());

        Printer printer = (msg) -> System.out.println(msg);
        printer.print("Print");

        Printer printer2 = (String msg) -> System.out.println(msg);
        printer2.print("Print2");


        Comparator<String> c = (s1, s2) -> s1.compareToIgnoreCase(s2);
    }

    @Test
    public void test3() {
        Processor stringProcessor = (str) -> str.length();
        String name = "Java Lambda";
        System.out.println(stringProcessor);
        int length = stringProcessor.getStringLength(name);
        System.out.println(length);
    }
}

