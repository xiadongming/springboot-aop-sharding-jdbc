package com.example.demo.commonutils;

import com.example.demo.common.KafkaKeys;
import com.example.demo.jobs.RedisJobs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {
    final Logger logger = LoggerFactory.getLogger(KafkaSender.class);
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    public void send(String value){
        logger.info("kafka发送的数据消息是："+value);
        kafkaTemplate.send(KafkaKeys.CT_KAFKA,value);
        //kafkaTemplate.receive();
    }


}
