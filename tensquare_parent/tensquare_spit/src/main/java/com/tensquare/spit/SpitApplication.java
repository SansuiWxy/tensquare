package com.tensquare.spit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import util.IdWorker;

/**
 * @description:
 * @author: caipeng
 * @create: 2019-04-15 09:30
 */
@EnableSwagger2//支持swagger2插件配置
@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class})
public class SpitApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpitApplication.class, args);
    }

    @Bean
    public IdWorker idWorkker() {
        return new IdWorker(1, 1);
    }

}

