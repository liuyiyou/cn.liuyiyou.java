package cn.liuyiyou.java8.predicate;

import cn.liuyiyou.model.User;
import com.google.common.base.Function;
import org.junit.Test;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;


/***
 * @author: liuyiyou
 * @date: 2018/4/25
 */
public class PredicateExample {


    /**
     * predicate: 断言
     */
    @Test
    public void predicate() {
        Predicate<String> predicate = (s -> s.length() > 0);
        boolean test = predicate.test("foo");
        boolean foot = predicate.negate().test("foot");
        System.out.println(test);
        System.out.println(foot);

        Predicate<String> notNull = Objects::nonNull;
        System.out.println(notNull.test(null));
    }

    /**
     * 函数：
     */
    public void function() {
        Function<String, Integer> toInteger = Integer::valueOf;
        Integer apply = toInteger.apply("123");

    }


    @Test
    public void supplier() {
        Supplier<User> userSupplier = User::new;
        System.out.println(userSupplier.get());
        System.out.println(userSupplier.get().getId());

        User u = new User();
        System.out.println(u.getId());
    }
}

