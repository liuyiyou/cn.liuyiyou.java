package cn.liuyiyou.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author: liuyiyou.cn
 * @date: 2019/11/6
 * @version: V1.0
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("hello Job");
    }
}
