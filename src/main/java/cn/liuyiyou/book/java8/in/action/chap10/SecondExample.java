package cn.liuyiyou.book.java8.in.action.chap10;

import java.util.Optional;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/20
 * @version: V1.0
 */
public class SecondExample {


    public static void main(String[] args) {

        System.out.println(new SecondExample().getCarInsuranceName1(Optional.empty()));
    }

    /**
     * 抛出NPE
     *
     * @param person
     * @return
     */
    public String getCarInsuranceName1(Optional<OptionPerson> person) {
        return person.flatMap(OptionPerson::getCar).flatMap(OptionCar::getInsurance).map(Insurance::getName).orElse("None");
    }


}
