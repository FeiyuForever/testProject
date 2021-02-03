package com.feiyu.data.practise.juniorrank;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by xzhou.James on 2020/9/20
 * <p>
 * 判断一个字符串是否包含另一个字符串
 */
public class StringContianRelation1 {

    private static final Logger logger = LoggerFactory.getLogger(StringContianRelation1.class);

    private static Long start = 0L;

    private static Long end = 0L;

    public static void main(String[] args) {
        try {
            System.out.println("====匹配开始====");
            start = System.currentTimeMillis();
            String first = "华为技术有限公司";
            String second = "华为技术公司";
            Map<Boolean, String> flag = getResult(first, second);
            Set<Map.Entry<Boolean, String>> set = flag.entrySet();
            for (Map.Entry<Boolean, String> elem : set) {
                System.out.println(elem.getKey() + " : " + elem.getValue());
            }
            end = System.currentTimeMillis();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("====匹配结束====");
            System.out.println("耗费时间: ["+(end-start)+"] ms");
        }
    }

    private static Map<Boolean, String> getResult(String first, String second) {
        Map<Boolean, String> map = new HashMap<>();
        if (StringUtils.isBlank(first) || StringUtils.isBlank(second)) {
            return map;
        }
        String maxString = "";
        String minString = "";
        maxString = first.length() > second.length() ? first : second;
        minString = first.length() < second.length() ? first : second;
        if (maxString.contains(minString)) {
            map.put(true, minString);
            return map;
        }
        int tempLength = 0;
        String value = "";
        int subMinStringLength = minString.length();
        for (int i = subMinStringLength; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                String includeString = minString.substring(j, i);
                if (maxString.contains(includeString) && includeString.length() >= 2) {
                    int length = includeString.length();
                    if (tempLength == 0) {
                        tempLength = length;
                        value = includeString;
                    } else if (length > tempLength) {
                        tempLength = length;
                        value = includeString;
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        if (tempLength > 0) {
            map.put(true, value);
            return map;
        } else {
            map.put(false, "未找到匹配字符");
            return map;
        }
    }
}
