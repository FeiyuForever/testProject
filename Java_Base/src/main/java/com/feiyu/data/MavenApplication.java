package com.feiyu.data;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @Author xzhou.James
 * @Date 2019/12/15  17:20
 */
@SpringBootApplication
@SpringBootConfiguration
@MapperScan(basePackages = {"com.feiyu.data.ocean.repository"})
public class MavenApplication {

    private static final Logger logger = LoggerFactory.getLogger(MavenApplication.class);

    public static void main(String[] args) {
        ApplicationContext applicationContext;
        try {
            applicationContext = SpringApplication.run(MavenApplication.class,args);
        } catch (Exception e) {
            logger.error("MavenApplication()"+e);
        }
    }
}
