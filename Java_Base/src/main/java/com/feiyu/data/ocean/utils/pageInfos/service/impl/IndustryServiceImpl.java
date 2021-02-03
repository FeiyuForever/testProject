package com.feiyu.data.ocean.utils.pageInfos.service.impl;

import com.feiyu.data.ocean.utils.pageInfos.dto.IndustryCompete;
import com.feiyu.data.ocean.utils.pageInfos.service.IndustryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/2/19  10:56
 */
@Service
public class IndustryServiceImpl implements IndustryService{

    /**
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public List<IndustryCompete> findIndustryCompete1(Integer pageIndex, Integer pageSize) {
        List<IndustryCompete> industryCompetes = new ArrayList<IndustryCompete>();
        //构造实体类
        IndustryCompete industryCompete1 = new IndustryCompete("1001","小米","北京","张大");
        IndustryCompete industryCompete2 = new IndustryCompete("1002","小米","北京","张大");
        IndustryCompete industryCompete3 = new IndustryCompete("1003","小米","北京","张大");
        IndustryCompete industryCompete4 = new IndustryCompete("1004","小米","北京","张大");
        IndustryCompete industryCompete5 = new IndustryCompete("1005","小米","北京","张大");
        IndustryCompete industryCompete6 = new IndustryCompete("1006","小米","北京","张大");
        IndustryCompete industryCompete7 = new IndustryCompete("1007","小米","北京","张大");
        Collections.addAll(industryCompetes,industryCompete1,industryCompete2,industryCompete3,industryCompete4,industryCompete5,industryCompete6,industryCompete7);

        return industryCompetes;
    }

    /**
     *
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public List<IndustryCompete> findIndustryCompete2(Integer pageIndex, Integer pageSize) {

        List<IndustryCompete> industryCompetes = new ArrayList<IndustryCompete>();
        //构造实体类
        IndustryCompete industryCompete1 = new IndustryCompete("1008","华为","上海","李四");
        IndustryCompete industryCompete2 = new IndustryCompete("1009","华为","上海","李四");
        IndustryCompete industryCompete3 = new IndustryCompete("1010","华为","上海","李四");
        IndustryCompete industryCompete4 = new IndustryCompete("1011","华为","上海","李四");
        //IndustryCompete industryCompete5 = new IndustryCompete("1005","小米","北京","张大");
        //IndustryCompete industryCompete6 = new IndustryCompete("1006","小米","北京","张大");
        //IndustryCompete industryCompete7 = new IndustryCompete("1007","小米","北京","张大");
        Collections.addAll(industryCompetes,industryCompete1,industryCompete2,industryCompete3,industryCompete4);

        return industryCompetes;
    }


    @Override
    public List<IndustryCompete> findIndustryCompete3() {
        List<IndustryCompete> industryCompetes = new ArrayList<IndustryCompete>();
        //构造实体类
        IndustryCompete industryCompete1 = new IndustryCompete("1001","小米","北京","张大");
        IndustryCompete industryCompete2 = new IndustryCompete("1002","小米","北京","张大");
        IndustryCompete industryCompete3 = new IndustryCompete("1003","小米","北京","张大");
        IndustryCompete industryCompete4 = new IndustryCompete("1004","小米","北京","张大");
        IndustryCompete industryCompete5 = new IndustryCompete("1005","小米","北京","张大");
        IndustryCompete industryCompete6 = new IndustryCompete("1006","小米","北京","张大");
        IndustryCompete industryCompete7 = new IndustryCompete("1007","小米","北京","张大");
        Collections.addAll(industryCompetes,industryCompete1,industryCompete2,industryCompete3,industryCompete4,industryCompete5,industryCompete6,industryCompete7);

        return industryCompetes;
    }

    @Override
    public List<IndustryCompete> findIndustryCompete4() {
        List<IndustryCompete> industryCompetes = new ArrayList<IndustryCompete>();
        //构造实体类
        IndustryCompete industryCompete1 = new IndustryCompete("1008","华为","上海","李四");
        IndustryCompete industryCompete2 = new IndustryCompete("1009","华为","上海","李四");
        IndustryCompete industryCompete3 = new IndustryCompete("1010","华为","上海","李四");
        IndustryCompete industryCompete4 = new IndustryCompete("1011","华为","上海","李四");
        //IndustryCompete industryCompete5 = new IndustryCompete("1005","小米","北京","张大");
        //IndustryCompete industryCompete6 = new IndustryCompete("1006","小米","北京","张大");
        //IndustryCompete industryCompete7 = new IndustryCompete("1007","小米","北京","张大");
        Collections.addAll(industryCompetes,industryCompete1,industryCompete2,industryCompete3,industryCompete4);

        return industryCompetes;
    }
}
