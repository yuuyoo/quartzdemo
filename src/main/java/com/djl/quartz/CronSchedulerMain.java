package com.djl.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author DJL
 * @create 2019-06-18 11:12
 * @desc 实现Cron任务调度
 **/
public class CronSchedulerMain {
    public static void main(String[] args) throws SchedulerException {
        // 1.创建调度器
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        // 2.创建作业详情
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).build();
        // 3.创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                // 每月的星期三每间隔3秒执行任务
                .withSchedule(CronScheduleBuilder.cronSchedule("0/3 * * ? 6 3"))
                .build();
        // 4.设置触发器、作业到调度器中
        scheduler.scheduleJob(jobDetail, trigger);

        // 5. 启动调度器
        scheduler.start();
    }
}
