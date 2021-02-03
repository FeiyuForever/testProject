package com.feiyu.data.ocean.service.impl;

import com.feiyu.data.ocean.model.Company;
import com.feiyu.data.ocean.repository.CompanyRepository;
import com.feiyu.data.ocean.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/7/5  14:35
 */
@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<Company> findCompanyList() {
        List<Company> companies = companyRepository.findCompanyList();
        return companies ;
    }

    @Override
    public Company findCompany() {
        return companyRepository.findCompany();
    }
}
