package cn.liuyiyou.java8.action.chap10;

/**
 * @author: liuyiyou.cn
 * @date: 2019/2/20
 * @version: V1.0
 */
public class FirstExample {


    public static void main(String[] args) {

        //NPE
        // System.out.println(new FirstExample().getCarInsuranceName1(new Person()));
        System.out.println(new FirstExample().getCarInsuranceName2(new Person()));
        System.out.println(new FirstExample().getCarInsuranceName3(new Person()));
    }

    /**
     * 抛出NPE
     * @param person
     * @return
     */
    public String getCarInsuranceName1(Person person) {
        return person.getCar().getInsurance().getName();
    }


    /**
     * 防御式检查：深层质疑
     * @param person
     * @return
     */
    public String getCarInsuranceName2(Person person) {
        if (person != null) {
            Car car = person.getCar();
            if (car != null) {
                Insurance insurance = car.getInsurance();
                if (insurance != null) {
                    return insurance.getName();
                }
            }
        }
        return "NONE";
    }

    /**
     * 防御式检查：过多退出语句
     * @param person
     * @return
     */
    public String getCarInsuranceName3(Person person) {
        String NONE = "NONE";
        if (person == null) {
            return NONE;
        }
        Car car = person.getCar();
        if (car == null) {
            return NONE;
        }
        Insurance insurance = car.getInsurance();
        if (insurance == null) {
            return NONE;
        }
        return "NONE";
    }
}
