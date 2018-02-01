package cn.liuyiyou.java.thread;

import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * User: liuyiyou
 * Date: 14-9-14
 * Time: 下午7:50
 * Desc:启动线程的几种方式
 */
public class ThreadStart {

    /**
     * 第一种：Thread
     * */
    public void type1(){
        Thread thread = new Thread("type1"){
           public void run(){
               System.out.println("run type1");
           }
        } ;
        thread.start();

    }



    public static void main(String[] args) {
        new ThreadStart().type1();

        new MyThread().start();

        new Thread(new MyRunnable()).start();


        //传入task任务
        new Thread(new TimerTask() {
            @Override
            public void run() {
                System.out.println("run type4");
            }
        }).start();

    }





  }

class MyThread extends Thread{

    @Override
    public void run() {

        System.out.println("run type2");
    }
}

class  MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("run type3");
    }
}
