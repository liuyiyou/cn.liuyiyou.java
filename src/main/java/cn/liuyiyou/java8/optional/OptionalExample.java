package cn.liuyiyou.java8.optional;

import cn.liuyiyou.model.User;
import cn.liuyiyou.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @date: 2018/9/20
 * @version: V1.0
 */
public class OptionalExample {


    @Test(expected = NullPointerException.class)
    public void getCarInsuranceNameTest() {
        Person person = new Person();
        getCarInsuranceName(person);
    }

    public String getCarInsuranceName(Person person) {
        return person.getCar().getInsurance().getName();
    }

    public String getCarInsuranceName_1(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    String name = insurance.getName();
                    return name;
                }
            }
        }
        return StringUtils.EMPTY;
    }

    public String getCarInsuranceName_2(Person person) {
        String result = StringUtils.EMPTY;
        if (person == null) {
            return result;
        }
        Car car = person.getCar();
        if (car == null) {
            return result;
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return result;
        }
        result = insurance.getName();
        return result;
    }


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
