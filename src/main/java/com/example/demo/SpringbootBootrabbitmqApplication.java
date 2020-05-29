package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//@MapperScan("com.example.demo.dtomapper")//规定，只能配置对应的dao层，范围不能太大
@MapperScan("com.example.demo.dao")
@SpringBootApplication
public class SpringbootBootrabbitmqApplication {
	public static void main(String[] args) {
		/**SpringBoot 2.X 的 spring-boot-starter-data-redis 默认是以 lettuce 作为连接池的，
		 * 而在 lettuce ， elasticsearch transport 中都会依赖netty, 二者的netty 版本不一致，不能够兼容。
		 * **/
		// 设置环境变量，解决Es的netty与Netty服务本身不兼容问题
		System.setProperty("es.set.netty.runtime.available.processors","false");
		SpringApplication.run(SpringbootBootrabbitmqApplication.class, args);
	}
}
