package com.djl.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author DJL
 * @create 2019-06-18 10:55
 * @desc 实现简单调度器功能
 **/
public class SchedulerMain {
    public static void main(String[] args) throws SchedulerException {

        // 1.创建调度器
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        // 2.创建作业详情
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).build();
        // 3.创建触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                // 每间隔3秒执行
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(3))
                // 立即开始执行
                .startNow()
                .build();
        // 4.设置触发器、作业到调度器中
        scheduler.scheduleJob(jobDetail, trigger);

        // 5. 启动调度器
        scheduler.start();
    }
}
