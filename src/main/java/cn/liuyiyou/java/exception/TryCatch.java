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

    /**
     * 不管有没有出现异常，finally块中代码都会执行；
     * a,c, return 0
     *
     * @return
     */
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

    /**
     * finally中最好不要包含return，否则程序会提前退出，返回值不是try或catch中保存的返回值。
     * a c, return 2
     *
     * @return
     */
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

    /**
     * 不管有没有出现异常，finally块中代码都会执行；
     * a, b,c, return 2
     *
     * @return
     */
    public int tryCatch3() {
        try {
            System.out.println("a");
            int i = 1 / 0;
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("msg::"+e.getMessage());
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTrace) {
                System.out.println("异常文件名:" + stackTraceElement.getFileName());
                System.out.println("异常类名:" + stackTraceElement.getClassName());
                System.out.println("异常方法:" + stackTraceElement.getMethodName());
                System.out.println("所在行:" + stackTraceElement.getLineNumber());
            }
            System.out.println("b");
        } finally {
            System.out.println("c");
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new TryCatch().tryCatch());
        System.out.println(new TryCatch().tryCatch2());
        System.out.println(new TryCatch().tryCatch3());
    }
}
