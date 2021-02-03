package com.feiyu.data.practise.leetcode.huawei.ListAndMap;

import org.junit.Test;

import java.util.*;

/**
 * Created by xzhou.James on 2021/1/27
 *
 * 题目描述
 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，
 * 即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 *
 * 输入描述:
 * 先输入键值对的个数
 * 然后输入成对的index和value值，以空格隔开
 */
public class MapCountValue5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int next = sc.nextInt();
            TreeMap<Integer,Integer> map = new TreeMap<>();
            for (int i = 0; i < next; i++) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                if (map.containsKey(key)){
                    map.put(key,map.get(key)+value);
                }else {
                    map.put(key,value);
                }
            }
            for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
                System.out.println(integerIntegerEntry.getKey()+" "+integerIntegerEntry.getValue());
            }
        }
    }

    @Test
    public void Test(){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(1,2);
        map.put(2,2);
        map.put(3,2);
        map.replace(3,map.get(3)+5);
        System.out.println("map = " + map.size());
    }
}
