package cn.liuyiyou.java.cycle;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author liuyiyou.cn
 * @date 2017年10月23日 下午7:37:07
 * @version
 */
public class BreakExample {

    List<Integer> lists1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Test
    public void breakTest() {
        for (Integer param1 : lists1) {
            for (Integer param2 : lists1) {
                if (param2 == 3) {
                    System.out.println("内层循环break");
                    break;
                }
                System.out.println("内层for循环");
            }

            if (param1 == 3) {
                System.out.println("外层循环break");
                break;
            }
            System.out.println("外层for循环");
            System.out.println(param1);
        }
    }

    @Test
    public void returnTest() {
        for (Integer param1 : lists1) {
            for (Integer param2 : lists1) {
                if (param2 == 3) {
                    for (int i = 1; i < 10; i++) {
                        System.out.println("i::" + i);
                    }
                    System.out.println("内层循环break");
                    return;
                }
                System.out.println("内层for循环");
            }

            if (param1 == 3) {
                System.out.println("外层循环break");
                break;
            }
            System.out.println("外层for循环");
            System.out.println(param1);
        }
    }

}
