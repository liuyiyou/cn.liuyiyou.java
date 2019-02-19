package cn.liuyiyou.refactoring.chapter01_1;

/**
 * @author: liuyiyou@yanglaoban.com
 * @date: 2018/10/18
 * @version: V1.0
 * @Copyright: 2018 yanglaoban.com Inc. All rights reserved.
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
