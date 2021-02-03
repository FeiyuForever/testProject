package com.feiyu.data.factory.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by xzhou.James on 2020/12/6
 */
public class BeanInterface implements InitializingBean, DisposableBean {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BeanInterface() {
        System.out.println("BeanInterface is constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BeanInterface-destroy-message = " + message);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BeanInterface-afterPropertiesSet-message = " + message);
    }
}
