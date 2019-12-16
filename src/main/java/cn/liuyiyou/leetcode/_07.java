package cn.liuyiyou.leetcode;

/**
 * @author: liuyiyou.cn
 * @date: 2019/12/11
 * @version: V1.0
 */
public class _07 {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println("-123".substring(1));
        System.out.println(reverse(1534236469));
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        try {
            final String s = String.valueOf(x);
            if (x < 0) {
                final String substring = s.substring(1);
                final String reverse = new StringBuilder(substring).reverse().toString();
                return Integer.valueOf(reverse) * -1;
            } else {
                final String reverse = new StringBuilder(s).reverse().toString();
                return Integer.valueOf(reverse);
            }
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
