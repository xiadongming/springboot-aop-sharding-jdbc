package com.example.demo.web;

import com.example.demo.common.RedisKeys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class WebClientController {

	@Autowired
	private StringRedisTemplate  stringRedisTemplate;

	//@Async("taskExecutor")
	@RequestMapping(value = "/html",method = RequestMethod.GET)
	public void httpClientRequest() {

		System.out.println("当前线程是："+Thread.currentThread().getName());
		System.out.println("html  路径");
	}

	@RequestMapping(value = "" , method = RequestMethod.PUT)
	public void httpClientRequest2(String name) {

		Long redisid = stringRedisTemplate.opsForList().leftPush(RedisKeys.CT_KEY,name);
		System.out.println(redisid);
		System.out.println(" "+" get 路径");
	}

	@RequestMapping(value = "",method = RequestMethod.POST)
	public void httpClientRequest3() {
//		String redisString = stringRedisTemplate.opsForValue().get(RedisKeys.CT_KEY);
		String redisString = stringRedisTemplate.opsForList().rightPop(RedisKeys.CT_KEY);
		System.out.println(redisString);
		System.out.println(" "+""+"   post 路径");
	}

	@RequestMapping(value = "/result2" , method = RequestMethod.GET)
	public void httpClientRequest4(String name) {

		Long redisid = stringRedisTemplate.opsForList().leftPush(RedisKeys.CT_KEY,name);
		System.out.println(redisid);
		System.out.println(" "+" get 路径");
	}
	/**
	@RequestMapping(value = "/result5" , method = RequestMethod.GET)
	public void httpClientRequest5(String name) {

		Long redisid = stringRedisTemplate.opsForList().leftPush(RedisKeys.CT_KEY,name);
		System.out.println(redisid);
		System.out.println(" "+" get 路径");
	}
	 ***/




}
