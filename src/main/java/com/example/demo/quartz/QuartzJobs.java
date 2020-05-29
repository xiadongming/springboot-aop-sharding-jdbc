package com.example.demo.quartz;

import com.example.demo.service.UserService;
import com.example.demo.threadpool.ThreadPoolExector;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Iterator;
import java.util.Set;

public class QuartzJobs extends QuartzJobBean {

    @Autowired
    private ThreadPoolExector threadPoolExector;


    /**
     * 定时插入数据库一条数据
     * **/
   // @Async("taskExecutor")//放在此处是错误的
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("  定时执行  ");
        System.out.println("  当前线程：" + Thread.currentThread().getName());
        threadPoolExector.task();



    }


}
