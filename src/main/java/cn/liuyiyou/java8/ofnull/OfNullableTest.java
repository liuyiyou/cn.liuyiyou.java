package cn.liuyiyou.java8.ofnull;

import cn.liuyiyou.model.User;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static java.util.Optional.ofNullable;

/***
 * @author: liuyiyou
 * @date: 2018/7/12
 */
public class OfNullableTest {


    /**
     * 得到所有用户的姓名长度和城市长度，不抛出NPE
     */
    @Test
    public void test() {
        List<User> users = getUsers();
        ofNullable(users).ifPresent(notNullUsers -> {
            notNullUsers.forEach(user -> ofNullable(user).ifPresent(notNullUser -> {
                notNullUser.getUserName().length();
                ofNullable(notNullUser.getAddress()).ifPresent(address -> System.out.println(address.getCity()));
            }));
        });
    }


    /**
     * 构建Usesr为nul的用户列表
     */
    public List<User> getNullUsers() {
        List<User> users = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setUserName("name" + i);
            Address address = new Address();
            address.setCity("city" + i);
            users.add(user);
        }
        users.add(null);
        return users;
    }


    /**
     * 构建Address为nul的用户列表
     */
    public List<User> getUsers() {
        List<User> users = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setUserName("name" + i);
            Address address = new Address();
            address.setCity("city" + i);
            users.add(user);
        }
        User user = new User();
        user.setId(11);
        user.setUserName("name" + 11);
        user.setAddress(null);
        users.add(user);

        users.add(null);
        return users;
    }
}
