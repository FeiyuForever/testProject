package com.feiyu.data.ocean.utils.pageInfos.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/2/19  10:51
 */
public class PageUtils {

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
