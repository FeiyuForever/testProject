package com.feiyu.data.practise.test.other;

import org.apache.commons.collections.CollectionUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2020/7/19  16:28
 *
 * 等差数列 2 5 8 11 14 17 20 ......
 *
 * 求等差数列前n项的和
 */
public class ArithmeticSequence {
    public static void main(String[] args) throws Exception{
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10000;i++) {
            list.add(i == 0 ? 2 : list.get(i-1)+3);
        }
        String str;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while ((str = bufferedReader.readLine())!= null){
            if(Integer.parseInt(str) < 0){
                System.out.println("请输入大于0的正整数!");
                continue;
            }
            int result = getResult(str,list);
            System.out.println(result);
        }
    }

    private static int getResult(String str,List<Integer> list) throws Exception{
        int resultNum = 0;
        int temp = Integer.parseInt(str);
        if(temp > 0 && CollectionUtils.isNotEmpty(list)){
            for (int i = 0; i < list.size(); i++) {
                if(i < temp){
                    resultNum += list.get(i);
                }else{
                    break;
                }
            }
        }
        return resultNum;
    }
}
