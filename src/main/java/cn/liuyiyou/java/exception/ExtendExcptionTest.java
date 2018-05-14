package cn.liuyiyou.java.exception;

import org.junit.Test;

public class ExtendExcptionTest {

    //继承Exception的方法需要继续抛出或者TryCatch异常
    @Test
    public void test() throws ExtendException {
        throw new ExtendException();
    }

    //继承Exception的方法不需要继续抛出或者TryCatch异常
    @Test
    public void test2() {
        throw new ExtendRunTimeException();
    }
}
