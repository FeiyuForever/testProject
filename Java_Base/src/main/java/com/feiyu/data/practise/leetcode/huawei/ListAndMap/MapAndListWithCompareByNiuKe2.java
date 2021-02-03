package com.feiyu.data.practise.leetcode.huawei.ListAndMap;

import java.util.*;

/**
 * Created by xzhou.James on 2021/1/3
 *
 * 题目描述
 * 查找和排序
 *
 * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 * 都按先录入排列在前的规则处理。
 *
 * 例示：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 *
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 *
 * 从低到高
 *
 * smith     67
 *
 * jack      70
 *
 * Tom       70
 * peter     96
 *
 * 注：0代表从高到低，1代表从低到高
 *
 * 本题含有多组输入数据！
 */
public class MapAndListWithCompareByNiuKe2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int order = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                int score = sc.nextInt();
                list.add(score);
                map.put(name + " " + score, score);
            }
            Collections.sort(list);
            if (order == 0) {
                Collections.reverse(list);
            }
            int pre = -1;
            for (int i : list) {
                if (pre == i){
                    continue;
                }
                for (String key : map.keySet()) {
                    if (map.get(key).equals(i)){
                        System.out.println(key);
                        pre = i;
                    }
                }
            }
        }
    }
}
