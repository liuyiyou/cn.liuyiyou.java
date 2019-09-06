package cn.liuyiyou.java.thread.type;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: liuyiyou.cn
 * @date: 2019/9/5
 * @version: V1.0
 */
public class NewThreadByThreadPool {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future> list = new ArrayList<>();
        final Future<?> implement_run = pool.submit(() -> System.out.println("implement run"));
        final Future<String> stringFuture = pool.submit(() -> {
            System.out.println("implement callable");
            return "syccess";
        });
    }
}
