package cn.liuyiyou.java.thread;

/**
 * @author: liuyiyou@yanglaoban.com
 * @date: 2018/10/22
 * @version: V1.0
 * @Copyright: 2018 yanglaoban.com Inc. All rights reserved.
 */
public class SleepMessages {
    public static void main(String args[]) throws InterruptedException {
        String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (int i = 0;
             i < importantInfo.length; i++) {
            //Pause for 4 seconds
            Thread.sleep(4000);
            //Print a message
            System.out.println(importantInfo[i]);
        }
    }
}


