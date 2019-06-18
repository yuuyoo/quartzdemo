package com.djl.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Calendar;

/**
 * @author DJL
 * @create 2019-06-18 10:51
 * @desc 任务作业
 **/
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 打印Hello World
        System.out.println(Calendar.getInstance().getTime() + "：Hello World!");
    }
}
