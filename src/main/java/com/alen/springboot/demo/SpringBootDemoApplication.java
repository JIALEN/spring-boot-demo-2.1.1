package com.alen.springboot.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
//自动扫描所有Spring组件，包括@Configuration类,,Controller等。
@ComponentScan(basePackages = "com.alen.springboot.demo.*")
//让 Spring Boot   根据应用所声明的依赖来对 Spring 框架进行自动配置 ，如果@ComponentScan扫描到此类了可以不加
@EnableAutoConfiguration
@EnableAsync//开启异步调用
@MapperScan(basePackages ="com.alen.springboot.demo.dao")
@EnableCaching // 开启缓存注解
public class SpringBootDemoApplication extends SpringBootServletInitializer {
    /**
     * 重写方法
     * @param application
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootDemoApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}
