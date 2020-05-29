package com.example.demo.threadpool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ThreadPoolConfig {
/**
 * 定义一个线程池，
 * 使用线程池时，在方法上引入注解@Async("taskExecutor")即可
 * **/
 @Bean
 public TaskExecutor taskExecutor(){
     ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
     threadPoolTaskExecutor.setCorePoolSize(3);//核心线程数
     threadPoolTaskExecutor.setMaxPoolSize(10);//最大线程数
     threadPoolTaskExecutor.setQueueCapacity(5);//队列最大容量
     threadPoolTaskExecutor.setKeepAliveSeconds(30);//空闲30秒后被回收
     threadPoolTaskExecutor.setThreadNamePrefix("thread-");
     threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());//拒绝策略
     threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);//所有任务完成后，关闭线程池
     return  threadPoolTaskExecutor;
 }
}
