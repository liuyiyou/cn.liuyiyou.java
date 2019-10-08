package cn.liuyiyou.refactoring.chapter01_1;

/**
 * @author: liuyiyou@liuyiyou.cn
 * @date: 2018/10/18
 * @version: V1.0
 * @Copyright: 2018 liuyiyou.cn Inc. All rights reserved.
 */
public class Rental {

    private Movie movie;
    private  int daySented;

    public Rental(Movie movie, int daySented) {
        this.movie = movie;
        this.daySented = daySented;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getDaySented() {
        return daySented;
    }

    public void setDaySented(int daySented) {
        this.daySented = daySented;
    }
}
