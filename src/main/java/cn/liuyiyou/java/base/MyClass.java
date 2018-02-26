package cn.liuyiyou.java.base;

/**
 * User: liuyiyou
 * Date: 14-9-14
 * Time: 下午8:10
 */
public class MyClass {

    public void sayHello() {
        System.out.println("SayHello ");
    }

    public static void main(String[] args) {
        new MyClass().sayHello();
        new MyInterfaceImpl().sayHello();
    }
}


interface MyInterface {

    void sayHello();
}

class MyInterfaceImpl implements MyInterface {

    @Override
    public void sayHello() {
        System.out.println("Say Hello");
    }
}