package com.feiyu.data.ocean.utils.pageInfos.service;

import com.feiyu.data.ocean.utils.pageInfos.dto.IndustryCompete;

import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/2/19  10:54
 */
public interface IndustryService {

    List<IndustryCompete> findIndustryCompete1(Integer pageIndex,Integer pageSize);

    List<IndustryCompete> findIndustryCompete2(Integer pageIndex,Integer pageSize);

    List<IndustryCompete> findIndustryCompete3();

    List<IndustryCompete> findIndustryCompete4();
}
