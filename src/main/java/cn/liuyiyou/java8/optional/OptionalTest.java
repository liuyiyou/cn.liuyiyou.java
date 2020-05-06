/**
 * 所属项目:cn.liuyiyou.java
 * 文件名称:cn.liuyiyou.java8.OptionalTest.java
 * 日期: 2017年9月21日上午9:50:08
 * Copyright (c) 2017, liuyiyou.cn All Rights Reserved.
 */
package cn.liuyiyou.java8.optional;

import cn.liuyiyou.model.User;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @author liuyiyou.cn
 * @date 2017年9月21日 上午9:50:08
 */
public class OptionalTest {

    /**
     * Optional.of()或者Optional.ofNullable()，of不允许参数是null，而ofNullable则无限制。
     */
    @Test
    public void ofANdOfNullableTest() {
        Optional<Object> ofNullable = ofNullable(null); //success
        boolean present = ofNullable.isPresent();
        System.out.println(present);
        Optional<Object> of = Optional.of(null); //NPE

    }

    /**
     * OfNULL测试
     */
    @Test
    public void ofNullableTest() {
        List<User> users = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setAge(1);
            u.setUserName(i + "n");
            users.add(u);
        }
        users.add(null);

        User u = new User();
        u.setAge(1);
        u.setUserName(null);
        users.add(u);

        users.forEach(user -> ofNullable(user).ifPresent(user1 -> ofNullable(user1.getUserName()).ifPresent(n -> System.out.println(n.length()))));
        System.out.println("--------------------");
        users.stream().filter(Objects::nonNull).map(User::getUserName).filter(Objects::nonNull).map(String::length).collect(Collectors.toList()).forEach(System.out::println);
    }


    @Test
    public void optionTest() {
        Optional<User> user = Optional.ofNullable(null);
        if (user.isPresent()) {
            System.out.println(user.get().getUserName());
        } else {
            System.out.println("xx");
        }
    }

    @Test
    public void optionTest2() {
        Optional<String> name = ofNullable(null);
        name.ifPresent(String::length);
    }

    @Test
    public void teset3() {
        final Collection<Streams.Task> tasks = Arrays.asList(
                new Streams.Task(Streams.Status.OPEN, 5),
                new Streams.Task(Streams.Status.OPEN, 13),
                new Streams.Task(Streams.Status.CLOSES, 8));

        final long totalPoints = tasks.stream().filter(task -> task.getStatus() == Streams.Status.OPEN)
                .mapToInt(Streams.Task::getPoionts).sum();
        System.out.println(totalPoints);
    }

    @Test
    public void beforeJava8() {
        Outer outer = new Outer();
        if (outer.nested.inner != null) {
            System.out.println(outer.nested.inner.foo);
        } else {
            System.out.println("为null");
        }

    }

    // map方法输入参数是lambda表达式，自动封装每个函数返回值至Optional，且可以管道式连接多个map操作，null检查自动完成。
    @Test
    public void onJava8() {
        String s = Optional.of(new Outer()).map(Outer::getNested).map(Nested::getInner).map(Inner::getFoo).orElse("");
        System.out.println(s);
        //Optional.of(new Outer()).map(Outer::getNested).map(Nested::getInner).map(Inner::getFoo).isPresent()?1:2
    }

}








