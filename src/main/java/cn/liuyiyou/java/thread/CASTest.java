package cn.liuyiyou.java.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: liuyiyou.cn
 * @date: 2019/4/18
 * @version: V1.0
 */
public class CASTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Future<?> submit = executorService.submit(new Test());
    }


}

class Test implements Runnable{
    static int i = 0;

    @Override
    public void run() {
        i++;
    }

}
