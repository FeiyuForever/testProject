package com.feiyu.data.factory.bean;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;

/**
 * Created by xzhou.James on 2020/12/6
 */
public class TestBeanClass {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BeanConfigXml.class);

    /**
     * 自定义 xml文件 测试 （ApplicationContext）
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/*/bean-config.xml");
        BeanConfigXml beanConfigXml = (BeanConfigXml)context.getBean("beanConfigXml");
        System.out.println(beanConfigXml.getMessage());
        logger.info("beanConfigXml.getMessage():{}",beanConfigXml.getMessage());
    }

    /**
     * 自定义  第三方的bean元素
     *
     * AnnotationConfigApplicationContext
     */
    @Test
    public void TestBeanAnnotation(){
        AnnotationConfigApplicationContext context  = new AnnotationConfigApplicationContext(BeanConfig.class);
        logger.info("TestBeanAnnotation is start 初始化");
        logger.info("TestBeanAnnotation is start 准备关闭");
        context.close();
        logger.info("TestBeanAnnotation is start 关闭完成");
    }

    /*@PostConstruct
    public void getMessageName(){
        try {
            logger.info("BeanConfigXml is start...");
            BeanConfigXml beanConfigXml = new BeanConfigXml();
            beanConfigXml.initBean();
            beanConfigXml.destoryBean();
            logger.info("BeanConfigXml is end...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
