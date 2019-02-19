package cn.liuyiyou.java8.options;

import cn.liuyiyou.model.User;
import cn.liuyiyou.service.UserService;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
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
        str3.ifPresent(x -> System.out.println(x));


        Optional.ofNullable(nullStr).orElseThrow(() -> new RuntimeException("的用户没有找到"));


    }


    @Test
    public void method2() {
        System.out.println(getUserCount());
        System.out.println(getUserCountSimple());

        System.out.println(getMobile());
        System.out.println(getSimpleMobile());

    }


    public int getMobile() {
        User user = UserService.getUser();
        if (user != null) {
            if (user.getMobile() != null) {
                return user.getMobile().length();
            }

        }
        return 0;
    }

    public int getSimpleMobile() {
        User user = UserService.getUser();
        return Optional.ofNullable(user).map(User::getMobile).orElse("").length();
    }


    public static int getUserCountSimple() {
        List<User> users = UserService.getNullUsers();
        return Optional.ofNullable(users).orElse(new ArrayList<>()).size();
    }

    public static int getUserCount() {
        List<User> users = UserService.getNullUsers();
        if (users != null && !users.isEmpty()) {
            return users.size();
        } else {
            return 0;
        }
    }


    @Test
    public void method3() {

        Integer expId = null;

        if (expId == null) {
            System.out.println("doOne");
        } else {
            System.out.println("doOtherOne");
        }

        Optional<String> strOptional = Optional.of("Hello World!");

        Optional.ofNullable(expId).ifPresent(x -> {
            System.out.println("doOtherOne");
        });

    }
}
