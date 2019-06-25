package cn.liuyiyou.service;

import cn.liuyiyou.model.User;
import com.alibaba.druid.util.JdbcUtils;

import java.util.List;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/10/23
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
public final class UserService {



    private UserService() {
    }

    public static List<User> getNullUsers() {
        return null;
    }

    public static List<User> getUsers() {
        return null;
    }

    /**
     * 得到null用户
     *
     * @return
     */
    public static User getNullUser() {
        return null;
    }

    /**
     * 得到非空用户
     *
     * @return
     */
    public static User getUser() {
        User user = new User();
        user.setId(1);
        return user;
    }
}
