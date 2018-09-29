package cn.liuyiyou.java8.options;

import org.junit.Test;

import java.util.Optional;

/**
 * @author: liuyiyou@yanglaoban.com
 * @date: 2018/9/20
 * @version: V1.0
 * @Copyright: 2018 yanglaoban.com Inc. All rights reserved.
 */
public class OptionalExample {

    @Test
    public void method() {
        Optional<String> empty = Optional.empty();
        System.out.println(empty.isPresent());

        Optional<String> str = Optional.of("Hello");
        System.out.println(str.get());

        String emptyStr = "";
        Optional<String> str2 = Optional.of(emptyStr);
        System.out.println(str2.get());


        String nullStr = null;
        Optional<String> str3 = Optional.ofNullable(nullStr);
        str3.orElse("aaa");
        str3.ifPresent(x->System.out.println(x));

    }
}
