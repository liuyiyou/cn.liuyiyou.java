package cn.liuyiyou.java.exception;

/**
 * 结论：
 * 1、不管有木有出现异常，finally块中代码都会执行；
 * 2、当try和catch中有return时，finally仍然会执行；
 * 3、finally是在return后面的表达式运算后执行的（此时并没有返回运算后的值，而是先把要返回的值保存起来，
 * 管finally中的代码怎么样，返回的值都不会改变，任然是之前保存的值），所以函数返回值是在finally执行前确定的；
 * 4、finally中最好不要包含return，否则程序会提前退出，返回值不是try或catch中保存的返回值。
 */
public class TryCatch {

    public int tryCatch() {
        try {
            System.out.println("a");
            return 0;
        } catch (Exception e) {
            System.out.println("b");
        } finally {
            System.out.println("c");
        }
        return 1;
    }

    public int tryCatch2() {
        try {
            System.out.println("a");
            return 0;
        } catch (Exception e) {
            System.out.println("b");
        } finally {
            System.out.println("c");
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new TryCatch().tryCatch());
        System.out.println(new TryCatch().tryCatch2());
    }
}
