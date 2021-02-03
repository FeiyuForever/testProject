package com.feiyu.data.service;

import com.feiyu.data.MavenApplication;
import com.feiyu.data.ocean.model.Company;
import com.feiyu.data.ocean.service.CompanyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/7/5  14:37
 */
@SpringBootTest(classes = MavenApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class CompanyServiceTest {

    private static final Logger log = LoggerFactory.getLogger(CompanyServiceTest.class);

    @Autowired
    private CompanyService companyService;

    @Test
    public void TestCompanyList(){
        List<Company> companies = companyService.findCompanyList();
        if(null == companies){
            System.out.println(666);
        }else{
            System.out.println(999);
        }
    }

    @Test
    public void TestCompany(){
        Company companies = companyService.findCompany();
        if(null == companies){
            System.out.println(666);
        }else{
            System.out.println(999);
        }
    }
}
