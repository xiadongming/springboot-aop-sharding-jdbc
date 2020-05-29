package com.example.demo.commonutils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class RedisTemplateUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    /**
     * 设置过期时间
     * **/
    public boolean expire(String key, long time) {
            if (time > 0) {
                Boolean expire = redisTemplate.expire(key, time, TimeUnit.SECONDS);
                return expire;
             }
           return false;
     }
    /**
     * 获取过期时间
     * **/
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }
    /**
     * 判断key是否存在
     * **/
    public boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
