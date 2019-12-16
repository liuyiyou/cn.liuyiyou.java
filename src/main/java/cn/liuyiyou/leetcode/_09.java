package cn.liuyiyou.leetcode;

/**
 * @author: liuyiyou.cn
 * @date: 2019/12/16
 * @version: V1.0
 */
public class _09 {

    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        String str = String.valueOf(x);
        int l = str.length() - 1;
        int r = 0;
        while (l > r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l--;
            r++;
        }
        return true;
    }
}
