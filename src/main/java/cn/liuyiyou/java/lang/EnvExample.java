package cn.liuyiyou.java.lang;

import org.junit.Test;

import java.util.Map;

/**
 * @author: liuyiyou.cn
 * @date: 2019/3/1
 * @version: V1.0
 */
public class EnvExample {

    @Test
    public void getEnv() {

        Map<String, String> evn = System.getenv();
        evn.forEach((key, value) -> {
            System.out.println(key + "=" + value);
        });
    }
}
