package cn.liuyiyou.java8.ofnull;


/***
 * @author: liuyiyou
 * @date: 2018/7/12
 */
public class User {
    private Integer id;
    private String name;
    private Address address;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
