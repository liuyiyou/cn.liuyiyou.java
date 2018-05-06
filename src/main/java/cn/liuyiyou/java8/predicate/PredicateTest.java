package cn.liuyiyou.java8.predicate;

import com.google.common.base.Function;

import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;


/***
 * @author: liuyiyou
 * @date: 2018/4/25
 */
public class PredicateTest {


    public static void main(String[] args) {

        supplier();

    }

    public static  void predicate(){
        Predicate<String> predicate = (s -> s.length() > 0);
        boolean test = predicate.test("foo");
        boolean foot = predicate.negate().test("foot");
        System.out.println(test);
        System.out.println(foot);

        Predicate<String> notNull = Objects::nonNull;
        System.out.println(notNull.test(null));
    }

    public static void function(){
        Function<String, Integer> toInteger = Integer::valueOf;
        Integer apply = toInteger.apply("123");

    }


    public static void  supplier(){
        Supplier<User> userSupplier = User::new;
        System.out.println(userSupplier.get());
        System.out.println(userSupplier.get().getName());


        User u = new User();
        System.out.println(u.getName());
    }
}

class User {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
