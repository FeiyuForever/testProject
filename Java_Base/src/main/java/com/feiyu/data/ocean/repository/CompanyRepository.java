package com.feiyu.data.ocean.repository;

import com.feiyu.data.ocean.model.Company;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/7/5  14:27
 */
@Repository
public interface CompanyRepository {

    @Select("select * from company where companyId = 50000")
    List<Company> findCompanyList();

    @Select("select * from company where companyId = 50000")
    Company findCompany();
}
