package com.feiyu.data.factory.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

/**
 * Created by xzhou.James on 2020/12/6
 */
public class BeanConfigXml {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void initBean() throws Exception{
        System.out.println("初始化BeanMessage = " + message);
    }

    public void destoryBean() throws Exception{
        System.out.println("消亡BeanMessage");
    }

}
