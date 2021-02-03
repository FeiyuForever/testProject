package com.feiyu.data.test.spring.impl;

import com.feiyu.data.test.spring.RecycleAService;
import com.feiyu.data.test.spring.RecycleBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by xzhou.James on 2020/12/13
 */

@Service
public class RecycleBServiceImpl implements RecycleBService {

    @Autowired
    private RecycleAService recycleAService;

    @Override
    public void getBService() {
        System.out.println("我是B接口");

        System.out.println("=============");

        //fixme 循环依赖问题
        //recycleAService.getAService();

        System.out.println("调用A接口结束");
    }

    /*@PostConstruct
    public void TestPostConstruct(){
        this.getBService();
    }*/
}
