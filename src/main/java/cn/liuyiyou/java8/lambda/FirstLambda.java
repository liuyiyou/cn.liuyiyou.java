package cn.liuyiyou.java8.lambda;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

/***
 * @author: liuyiyou
 * @date: 2018/4/23
 */
public class FirstLambda {

    public static void main(String[] args) {

        IntBinaryOperator addtition = (int x, int y) -> x + y;

        System.out.println(addtition.applyAsInt(2,3));
    }
}
