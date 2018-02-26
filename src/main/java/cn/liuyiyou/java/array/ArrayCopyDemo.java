package cn.liuyiyou.java.array;

/***
 * @author: liuyiyou
 * @date: 2018/2/26
 */
public class ArrayCopyDemo {

    public static void main(String[] args) {
        char[] copyFrom = {'d', 'e', 'c', 'a', 'f', 'f', 'e',
                'i', 'n', 'a', 't', 'e', 'd'};
        char[] copyTo = new char[7];

        System.arraycopy(copyFrom, 2, copyTo, 0, 7);
        System.out.println(new String(copyTo));


        char[] copyTo2 = java.util.Arrays.copyOfRange(copyFrom, 2, 9);

        System.out.println(new String(copyTo2));
    }
}
