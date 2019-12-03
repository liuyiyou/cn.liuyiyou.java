package cn.liuyiyou.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: liuyiyou.cn
 * @date: 2019/11/7
 * @version: V1.0
 */
public class RedisPoolExample {

    /**
     * 模拟慢查询引起的 Could not get a resource from the pool
     *
     * @param args
     */
    public static void main(String[] args) {

        JedisPoolConfig poolConfig = new JedisPoolConfig();
//        poolConfig.setMaxWaitMillis(2000);
//        poolConfig.setMaxTotal(80);
//        poolConfig.setMaxIdle(50);
//        poolConfig.setTestOnBorrow(true);
//        poolConfig.setMinIdle(5);
        JedisPool jedisPool = new JedisPool(poolConfig, "192.168.0.200", 6379,1,"ibalife");

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(() -> {
                Jedis jedis = null;
                try {
                    jedis = jedisPool.getResource();
                    jedis.hset("UserPayAccount:total", "ALL_PAGE", bigStr());
                    final Thread currentThread = Thread.currentThread();
//                    Thread.sleep(1000L);
                    System.out.println("当前线程:"+currentThread.getName());
//                    jedis.hgetAll("UserPayAccount:total");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
//                    jedisPool.close();
                    jedis.close();
                }
            }, "Thread"+i);
            thread.start();
        }


    }

    public static String bigStr() {
        String value = "abcdeftgh";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            stringBuilder.append(value);
        }
        return stringBuilder.toString();
    }
}
