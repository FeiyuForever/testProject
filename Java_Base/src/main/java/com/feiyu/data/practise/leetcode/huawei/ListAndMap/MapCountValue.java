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
public class MapCountValue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            Map<Integer,Integer> map = new HashMap<Integer,Integer>(Integer.parseInt(String.valueOf(Math.pow(2,num)).split("\\.")[0]));
            Scanner in = new Scanner(System.in);
            int count = 0;
            while (in.hasNext()){
                count ++;
                String[] lineNum = in.nextLine().split(" ");
                if(!map.containsKey(Integer.valueOf(lineNum[0]))){
                    map.put(Integer.valueOf(lineNum[0]),Integer.valueOf(lineNum[1]));
                }else{
                    map.replace(Integer.valueOf(lineNum[0]),map.get(Integer.valueOf(lineNum[0]))+Integer.parseInt(lineNum[1]));
                }
                if(count == num){
                    break;
                }
            }
            Set<Map.Entry<Integer,Integer>> set = map.entrySet();
            set.stream().forEach(s -> System.out.println(s.getKey()+" "+s.getValue()));
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
