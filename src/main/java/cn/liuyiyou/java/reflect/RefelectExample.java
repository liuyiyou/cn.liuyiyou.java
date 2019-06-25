package cn.liuyiyou.java.reflect;

import cn.liuyiyou.model.NewPerson;
import org.junit.Test;

/**
 *
 * 反射实例
 * @author: liuyiyou.cn
 * @date: 2019/6/4
 * @version: V1.0
 */
public class RefelectExample {

    @Test
    public void testClass(){
        NewPerson person = new NewPerson();
        Class<? extends NewPerson> aClass = person.getClass();
        boolean instance = aClass.isInstance(person);
        System.out.println(instance);
    }
}
