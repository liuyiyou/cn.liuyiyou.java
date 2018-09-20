package cn.liuyiyou.spring;

import cn.liuyiyou.model.User;

import static org.springframework.beans.BeanUtils.copyProperties;

/***
 *
 * @author: liuyiyou.cn
 * @date: 2018/8/10
 * @Copyright 2018 liuyiyou.cn Inc. All rights reserved
 */
public class CopyPropertiesTest {

    public static void main(String[] args) {

        User user = new User();
        user.setId(1);
        user.setMobile(null);


        User user1 = new User();
        user1.setId(2);
        user1.setMobile("bbbb");

//        copyProperties(user, user1);
//
//        System.out.println(user1.getMobile());

        copyProperties(user, user1, "mobile");

        System.out.println(user1.getMobile());
    }
}


