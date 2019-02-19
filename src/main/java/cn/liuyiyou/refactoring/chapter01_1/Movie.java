package cn.liuyiyou.refactoring.chapter01_1;

/**
 * <p>影片</p>
 * @author: liuyiyou.cn
 * @date: 2018/10/18
 * @version: V1.0
 * @Copyright: 2018 liuyiyou.cn Inc. All rights reserved.
 */
public class Movie {

    public static final int CHILDRENDS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
}
