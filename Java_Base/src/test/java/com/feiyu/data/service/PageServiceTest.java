package com.feiyu.data.service;

import com.feiyu.data.MavenApplication;
import com.feiyu.data.ocean.utils.pageInfos.dto.IndustryCompete;
import com.feiyu.data.ocean.utils.pageInfos.service.IndustryService;
import com.feiyu.data.ocean.utils.pageInfos.test.TestPageClass;
import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/2/19  11:57
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MavenApplication.class)
public class PageServiceTest {

    private static  final Logger logger = LoggerFactory.getLogger(TestPageClass.class);

    @Autowired
    private IndustryService industryService;

    @Test
    public void TestPage(){
        List<IndustryCompete> industryCompeteList = new ArrayList<>();
        try {
            List<IndustryCompete> industryCompetes1 = industryService.findIndustryCompete1(1,5);
            List<IndustryCompete> industryCompetes2 = industryService.findIndustryCompete2(1,5);
            if(CollectionUtils.isNotEmpty(industryCompetes1)){
                industryCompeteList.addAll(industryCompetes1);
            }
            if(CollectionUtils.isNotEmpty(industryCompetes2)){
                industryCompeteList.addAll(industryCompetes2);
            }
            logger.info("industryCompeteList<><>"+industryCompeteList);
            List<IndustryCompete> industryCompetes = getPaging(industryCompeteList,3,5);
            if(CollectionUtils.isNotEmpty(industryCompetes)){
                logger.info("industryCompetes<><>"+industryCompetes);
                for (IndustryCompete industryCompete:industryCompetes) {
                    System.out.println(industryCompete.getCompeteId());
                }
            }
        }catch (Exception ex){
            logger.error("数据错误《》《》"+ex);
        }
    }

    //增加  分页
    private List<IndustryCompete> getPaging(List<IndustryCompete> allLeaveSubjectCreditRating, int pageIndex, int pageSize) {

        List<IndustryCompete> pageList = new ArrayList<IndustryCompete>();

        int currIdx = (pageIndex > 1 ? (pageIndex - 1) * pageSize : 0);
        for (int i = 0; i < pageSize && i < allLeaveSubjectCreditRating.size() - currIdx; i++) {
            IndustryCompete listNew = allLeaveSubjectCreditRating.get(currIdx + i);
            pageList.add(listNew);
        }
        return pageList;
    }
}
