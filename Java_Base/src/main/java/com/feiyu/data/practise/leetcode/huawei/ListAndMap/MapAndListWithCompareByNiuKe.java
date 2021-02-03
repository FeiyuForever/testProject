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
public class MapAndListWithCompareByNiuKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            int flag = Integer.parseInt(sc.nextLine());
            Map<String, Integer> map = new LinkedHashMap<String, Integer>();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                String[] str = sc.nextLine().split(" ");
                String str1 = str[0];
                int a = Integer.parseInt(str[1]);
                map.put(str1, a);
                array[i] = a;
            }
            Arrays.sort(array);   //对分数进行排序(升序)
            Set<String> set = map.keySet();
            //0表示降序，1表示升序
            if (flag == 1) {
                for (int i = 0; i < n; i++) {   //对数组中的元素进行一个个扫描
                    for (String s : set) {
                        if (map.get(s) == array[i]) {
                            System.out.println(s + " " + array[i]);
                            map.remove(s);
                            break;
                        }
                    }
                }
            } else {
                for (int i = n - 1; i >= 0; i--) {
                    for (String s : set) {
                        if (map.get(s) == array[i]) {
                            System.out.println(s + " " + array[i]);
                            map.remove(s);
                            break;
                        }
                    }
                }
            }
        }
    }
}
