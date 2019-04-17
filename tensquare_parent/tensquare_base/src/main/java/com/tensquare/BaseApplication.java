package com.tensquare;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import util.IdWorker;

/**
 * @description: Base启动类
 * @author: caipeng
 * @create: 2019-04-01 16:41
 */
@MapperScan(basePackages = {"com.tensquare.base.dao"})
@EnableSwagger2//支持swagger2插件配置
@SpringBootApplication
public class BaseApplication {

    /**
     * 启动方法
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);

    }

    /**
     * 准备一个id生成器，并且放到spring容器中
     *
     * @return
     */
    @Bean
    public IdWorker idWorker() {
        return new IdWorker(1, 1);
    }


}
