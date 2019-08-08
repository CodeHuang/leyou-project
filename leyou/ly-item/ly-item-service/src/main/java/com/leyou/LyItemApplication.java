package com.leyou;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @MapperScan 注解时引入了错误的包下的。
 *正确的应该是：import tk.mybatis.spring.annotation.MapperScan;
 *错误的引入了：import org.mybatis.spring.annotation.MapperScan;
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.leyou.item.mapper")
public class LyItemApplication {
    public static void main(String[] args) {
        SpringApplication.run(LyItemApplication.class);
    }
}
