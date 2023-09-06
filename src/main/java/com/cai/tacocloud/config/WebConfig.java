package com.cai.tacocloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    /*
      接收一个ViewControllerRegistry对象，可以使用它注册一个或多个视图控制器
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        /*
          将“/”传递进addViewController方法中，视图控制器将会针对该路径执行GET请求，这个方法会返回ViewControllerRegistration对象，
          我们马上基于该对象调用setViewName方法，用它指明当请求“/”的时候要转发到home视图上
          该语句可以替换HomeController类
         */
        registry.addViewController("/").setViewName("home");
    }
}
