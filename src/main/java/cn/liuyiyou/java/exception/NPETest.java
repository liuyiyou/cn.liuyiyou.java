package cn.liuyiyou.java.exception;

import cn.liuyiyou.model.User;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/15
 * @version: V1.0
 */
public class NPETest {

    public static void main(String[] args) {
        User myUser = new User();
        myUser.getAddress().getCity();
    }
}
