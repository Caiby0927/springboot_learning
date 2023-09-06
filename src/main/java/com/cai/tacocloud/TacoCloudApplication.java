package com.cai.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TacoCloudApplication { // implements WebMvcConfigurer
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

//	@Override
//    /*
//      接收一个ViewControllerRegistry对象，可以使用它注册一个或多个视图控制器
//     */
//	public void addViewControllers(ViewControllerRegistry registry) {
//        /*
//          将“/”传递进addViewController方法中，视图控制器将会针对该路径执行GET请求，这个方法会返回ViewControllerRegistration对象，
//          我们马上基于该对象调用setViewName方法，用它指明当请求“/”的时候要转发到home视图上
//          该语句可以替换HomeController类
//         */
//		registry.addViewController("/").setViewName("home");
//	}

}
