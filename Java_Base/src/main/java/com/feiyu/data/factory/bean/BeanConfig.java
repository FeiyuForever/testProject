package com.feiyu.data.factory.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by xzhou.James on 2020/12/6
 */
@Configuration
public class BeanConfig {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BeanConfigXml.class);

    //@Bean
    @Bean(name = "beanInterface")
    public BeanInterface beanInterface(){
        logger.info("initBeanConfig is start");
        BeanInterface beanInterface = new BeanInterface();
        beanInterface.setMessage("Hello James ,I'm your new partner");
        return beanInterface;
    }
}
