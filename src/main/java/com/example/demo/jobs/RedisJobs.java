package com.example.demo.jobs;

import com.example.demo.common.RedisKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Iterator;
import java.util.Set;

/**
 * 获取redis中的数据,在系统启动的时候，就开始执行
 * **/
@Component
public class RedisJobs implements ApplicationRunner {
    final  Logger logger = LoggerFactory.getLogger(RedisJobs.class);
    /***
     * 如果redis中有数据，就打印出来，通过pop
     * **/
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        //专门new一条线程，来做这个任务
     new Thread(){
         @Override
         public void run() {
               while (true){
                   String rightPopValue = stringRedisTemplate.opsForList().rightPop(RedisKeys.CT_KEY);
               //    Object o = redisTemplate.opsForList().rightPop(RedisKeys.CT_KEY);
                   //     logger.info("从redis中获取的消息是："+rightPopValue);
                 //  if(null != o){
               //        System.out.println("redisTemplate中获取消息："+o.toString());
               //    }
                   if(!StringUtils.isEmpty(rightPopValue)){
                       System.out.println("stringRedisTemplate中获取消息："+rightPopValue);
                   }
                   try {
                       Thread.sleep(2000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
         }
     }.start();



    }
}
