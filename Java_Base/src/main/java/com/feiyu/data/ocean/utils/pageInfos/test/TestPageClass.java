package com.feiyu.data.ocean.utils.pageInfos.test;

import com.feiyu.data.ocean.utils.pageInfos.dto.IndustryCompete;
import com.feiyu.data.ocean.utils.pageInfos.service.IndustryService;
import org.apache.commons.collections.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/2/19  11:07
 */
public class TestPageClass {

    private static  final  Logger logger = LoggerFactory.getLogger(TestPageClass.class);

    @Autowired
    private IndustryService industryService;


    @Test
    public void TestIndustry(){
        List<IndustryCompete> industryCompeteList = new ArrayList<>();
        try {
            List<IndustryCompete> industryCompetes1 = this.findIndustryCompete00();
            List<IndustryCompete> industryCompetes2 = this.findIndustryCompete11();
            if(CollectionUtils.isNotEmpty(industryCompetes1)){
                industryCompeteList.addAll(industryCompetes1);
            }
            if(CollectionUtils.isNotEmpty(industryCompetes2)){
                industryCompeteList.addAll(industryCompetes2);
            }
            logger.info("industryCompeteList<><>"+industryCompeteList);
            List<IndustryCompete> industryCompetes = getPaging(industryCompeteList,1,5);
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

    @Test
    public void TestIndustry1(){
        List<IndustryCompete> industryCompeteList = new ArrayList<>();
        try {
            List<IndustryCompete> industryCompetes1 = findIndustryCompete1(1,5);
            List<IndustryCompete> industryCompetes2 = findIndustryCompete2(1,5);
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

    public List<IndustryCompete> findIndustryCompete00() {
        List<IndustryCompete> industryCompetes = new ArrayList<IndustryCompete>();
        //构造实体类
        IndustryCompete industryCompete1 = new IndustryCompete("1001","小米","北京","张大");
        IndustryCompete industryCompete2 = new IndustryCompete("1002","小米","北京","张大");
        IndustryCompete industryCompete3 = new IndustryCompete("1003","小米","北京","张大");
        /*IndustryCompete industryCompete4 = new IndustryCompete("1004","小米","北京","张大");
        IndustryCompete industryCompete5 = new IndustryCompete("1005","小米","北京","张大");
        IndustryCompete industryCompete6 = new IndustryCompete("1006","小米","北京","张大");
        IndustryCompete industryCompete7 = new IndustryCompete("1007","小米","北京","张大");*/
        Collections.addAll(industryCompetes,industryCompete1,industryCompete2,industryCompete3);//,industryCompete4,industryCompete5,industryCompete6,industryCompete7

        return industryCompetes;
    }

    public List<IndustryCompete> findIndustryCompete11() {

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
}
