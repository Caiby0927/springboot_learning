package com.cai.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TacoCloudApplication {
	/*
	@SpringBootApplication是一个组合注解，由其他三个注解组合得到
	1、@SpringBootConfiguration：声明该类为配置类
	2、@EnableAutoConfiguration：启用Spring Boot的自动配置
	3、@ComponentScan：启用组件扫描
	*/

	/*
	JAR文件执行时需要运行的方法
	*/
	public static void main(String[] args) {
//		创建Spring的应用上下文
		SpringApplication.run(TacoCloudApplication.class, args);
	}

}
