package com.example.demo.jobs;

import com.example.demo.common.KafkaKeys;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerJobs {
    final Logger logger = LoggerFactory.getLogger(KafkaConsumerJobs.class);

  //  KafkaConsumer KafkaConsumer;
  //  KafkaTemplate KafkaTemplate;
    @KafkaListener(topics = KafkaKeys.CT_KAFKA)
    public void listen(ConsumerRecord<?, ?> record) {
        logger.info("kafka中获取的消息是："+record.value()+", topic是："+record.topic());
        System.out.println("打印：topic是"+record.topic()+"   消息内容是："+record.value());
       //
    }


}
