package com.example.demo.commonutils;

import com.example.demo.jobs.RedisJobs;
import com.sun.org.apache.xml.internal.security.Init;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerPoolManager implements InitializingBean {
    final Logger logger = LoggerFactory.getLogger(KafkaProducerPoolManager.class);
    /***
     * 当所有的bean属性被注入只有，会执行afterpropertiesSet()方法
     * **/
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行  KafkaProducerPoolManager implements InitializingBean ");
    }
}
