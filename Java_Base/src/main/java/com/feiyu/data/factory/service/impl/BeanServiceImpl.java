package com.feiyu.data.factory.service.impl;

import com.feiyu.data.factory.bean.BeanConfig;
import com.feiyu.data.factory.bean.BeanConfigXml;
import com.feiyu.data.factory.bean.BeanInterface;
import com.feiyu.data.factory.service.BeanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by xzhou.James on 2020/12/6
 */

@Service
public class BeanServiceImpl implements BeanService {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BeanConfigXml.class);


    /**
     * 第一种方式
     *
     * @Autowired 默认按照类型来进行注入，byType， + Qualifier可以实现byName
     */
    @Autowired
    @Qualifier(value = "beanInterface")
    private BeanInterface beanInterface;

    /**
     * 第二种方式
     * @Resource 默认按照名称来进行注入，byName ,找不到 用byType
     */
    /*@Resource
    private BeanConfig beanConfig;*/

    /**
     * 第三种方式
     */
    /*@Resource(name = "beanInterface")
    private BeanInterface beanInterface;*/


    /**
     * 注入
     * @return
     */
    @Override
    public BeanInterface getBeanInterfaceInfo() {
        logger.info("getBeanInterfaceInfo is start");
        //BeanInterface beanInterface = beanConfig.getBeanConfig();
        BeanInterface beanInterfaceName = new BeanInterface();
        beanInterfaceName.setMessage(beanInterface.getMessage());
        return beanInterfaceName;
    }

    @PostConstruct
    public void TestBean(){
        logger.info("TestBean is start");
        BeanInterface beanInterface = getBeanInterfaceInfo();
        logger.info("TestBean is start name:{}",beanInterface.getMessage());
        logger.info("TestBean is end");
    }
}
