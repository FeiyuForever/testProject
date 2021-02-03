package com.feiyu.data.ocean.service;

import com.feiyu.data.ocean.model.Company;

import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/7/5  14:34
 */
public interface CompanyService {

    List<Company> findCompanyList();

    Company findCompany();
}
