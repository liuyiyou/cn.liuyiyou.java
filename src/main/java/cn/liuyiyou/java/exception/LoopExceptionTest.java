package cn.liuyiyou.java.exception;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/8/20
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
public class LoopExceptionTest {


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("是否执行：" + i);
                System.out.println(1 / 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
