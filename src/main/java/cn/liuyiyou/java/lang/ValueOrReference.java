package cn.liuyiyou.java.lang;

import java.util.Collections;
import java.util.List;

/***
 *
 * Java到底是传值还是传引用
 * @author: liuyiyou
 * @date: 2018/5/6
 */
public class ValueOrReference {


    /***
     *基本类型
     * @param args
     */
    public static void mutipy(double x) {
        x = 3 * x;
    }

    public static void main(String[] args) {
        double percent = 10;
        mutipy(percent);
        System.out.println(percent); //always 10

        Employee x = new Employee("x");
        Employee y = new Employee("y");
        swap(x,y);
        System.out.println(x.getName());
        System.out.println(y.getName());
        System.out.println(x.getName());
        System.out.println(y.getName());
    }


    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }




}


class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
