package cn.liuyiyou.java.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @link https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/java/nutsandbolts/examples/ArrayDemo.java
 */
public class ArrayExample {

    /**
     * 使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方 法， 它的 add/remove/clear 方法会抛出
     * UnsupportedOperationException 异常。
     * <p>
     * <p>
     * 返回的是Arrays中的一个内部类，该内部类并没有实现add方法，但是如果是ArrayList是可以的
     */
    @Test(expected = UnsupportedOperationException.class)
    public void test1() {
        String[] str = new String[]{"liu", "yi"};
        List<String> list = Arrays.asList(str);
        list.add("you");
    }

    @Test
    public void copyTest() {
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};
        char[] copyTo = new char[7];

        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        System.out.println(new String(copyTo));


        char[] copyTo2 = java.util.Arrays.copyOfRange(copyFrom, 2, 9);

        System.out.println(new String(copyTo2));
    }

    public static void main(String[] args) {
        // declares an array of integers
        int[] anArray;
        // allocates memory for 10 integers
        anArray = new int[10];
        // initialize first element
        anArray[0] = 100;
        // initialize second element
        anArray[1] = 200;
        // and so forth
        anArray[2] = 300;
        anArray[3] = 400;
        anArray[4] = 500;
        anArray[5] = 600;
        anArray[6] = 700;
        anArray[7] = 800;
        anArray[8] = 900;
        anArray[9] = 1000;
        System.out.println("Element at index 0: " + anArray[0]);
        System.out.println("Element at index 1: "
                + anArray[1]);
        System.out.println("Element at index 2: "
                + anArray[2]);
        System.out.println("Element at index 3: "
                + anArray[3]);
        System.out.println("Element at index 4: "
                + anArray[4]);
        System.out.println("Element at index 5: "
                + anArray[5]);
        System.out.println("Element at index 6: "
                + anArray[6]);
        System.out.println("Element at index 7: "
                + anArray[7]);
        System.out.println("Element at index 8: "
                + anArray[8]);
        System.out.println("Element at index 9: "
                + anArray[9]);
    }
}