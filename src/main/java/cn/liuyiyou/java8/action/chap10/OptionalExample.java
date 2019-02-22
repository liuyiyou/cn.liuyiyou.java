package cn.liuyiyou.java8.action.chap10;

import org.junit.Test;

import java.util.Optional;
import java.util.jar.Attributes;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/20
 * @version: V1.0
 */
public class OptionalExample {

    public static void main(String[] args) {

    }

    @Test
    public void buildOption() {
        //通过静态工厂方法
        Optional<Car> optCar = Optional.empty();
        System.out.println(optCar);

        //非空值创建，如果是NULL，则抛出NPE
        Car car = new Car();
        Optional<Car> optCar2 = Optional.of(car);
        System.out.println(optCar2);


        //可接受Null的
        Optional<Car> optCar3 = Optional.ofNullable(null);
        System.out.println(optCar3);


    }



    @Test
    public void getOption() {
        //通过静态工厂方法
        Optional<Car> optCar = Optional.empty();
        //NPE
        //System.out.println(optCar.get());

        //非空值创建，如果是NULL，则抛出NPE
        Car car = new Car();
        Optional<Car> optCar2 = Optional.of(car);
        System.out.println(optCar2.get());


        //可接受Null的
        Optional<Car> optCar3 = Optional.ofNullable(null);
        //NPE
        System.out.println(optCar3.get());


        //使用Map从Optional对象中提取和转换值
        Insurance insurance = new Insurance();
        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optionalInsurance.map(Insurance::getName);

    }
}
