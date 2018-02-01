package cn.liuyiyou.java.exception;

/**
 * User: liuyiyou
 * Date: 14-8-22
 * Time: 下午6:56
 */
public class TryCatch {

    public int tryCatch(){

        try {
            System.out.println("a");
            return 0;
        } catch (Exception e){
            System.out.println("b");
        } finally {
            System.out.println("c");
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(        new TryCatch().tryCatch());
    }
}
