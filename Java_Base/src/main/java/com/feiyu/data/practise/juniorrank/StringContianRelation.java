package com.feiyu.data.practise.juniorrank;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by xzhou.James on 2020/9/20
 * <p>
 * 判断一个字符串是否包含另一个字符串
 */
public class StringContianRelation {

    private static final Logger logger = LoggerFactory.getLogger(StringContianRelation.class);

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                logger.info("str:{}", str);
                String first = str;
                String second = bufferedReader.readLine();
                boolean flag = getResult(first, second);
                if (flag) {
                    System.out.println(flag);
                } else {
                    System.out.println(flag);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    private static boolean getResult(String first, String second) {
        if (StringUtils.isBlank(first) || StringUtils.isBlank(second)) {
            return false;
        }
        String maxString = "";
        String minString = "";
        maxString = first.length() > second.length() ? first : second;
        minString = first.length() < second.length() ? first : second;
        if (maxString.contains(minString)) {
            return true;
        }
        int subMinStringLength = minString.length();
        boolean flag = false;
        for (int i = 0; i < subMinStringLength; i++) {
            for (int j = subMinStringLength - 1; j > 0; j--) {
                String includeString = minString.substring(i, j);
                if (maxString.contains(includeString)) {
                    flag = true;
                    break;
                } else {
                    continue;
                }
            }
        }
        return flag;
    }
}
