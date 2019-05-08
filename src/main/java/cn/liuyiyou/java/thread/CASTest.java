package cn.liuyiyou.java.thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: liuyiyou.cn
 * @date: 2019/4/18
 * @version: V1.0
 */
public class CASTest implements Runnable {


    static int i = 0;

    @Test
    public void test() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        Future<?> submit = executorService.submit(new CASTest());
        Object o = submit.get();
        System.out.println(o);
    }

    @Override
    public void run() {
        i++;

    }
}
