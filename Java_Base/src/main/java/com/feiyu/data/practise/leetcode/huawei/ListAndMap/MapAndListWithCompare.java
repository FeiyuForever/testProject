package com.feiyu.data.practise.leetcode.huawei.ListAndMap;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

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
public class MapAndListWithCompare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            Map<String, String> map = new LinkedHashMap<>();
            int count = Integer.valueOf(scanner.nextLine());
            int sort = Integer.valueOf(scanner.nextLine());
            for (int i = 0; i < count; i++) {
                if (map.size() == count) {
                    break;
                }
                //Scanner in = new Scanner(System.in);
                String str1 = scanner.nextLine();
                //System.out.println("str1:()"+str1);
                String[] stringArray = str1.split(" ");
                if (stringArray.length < 2) {
                    map.put(stringArray[0], "0");
                } else {
                    if (map.containsKey(stringArray[0])) {
                        continue;
                    }
                    map.put(stringArray[0], stringArray[1]);
                }
            }
            //System.out.println("map.size():"+map.size());
            Set<Map.Entry<String, String>> set = map.entrySet();
            List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(set);
            if (sort == 0 || sort == 1) {
                Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
                    @Override
                    public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                        if (sort == 1) {
                            return o1.getValue().compareTo(o2.getValue());
                        } else {
                            return o2.getValue().compareTo(o1.getValue());
                        }
                    }
                });
                //list.forEach(elem -> System.out.println(elem.getKey() + " " + elem.getValue()));
                for (Map.Entry<String, String> elem:list) {
                    System.out.println(elem.getKey()+" "+elem.getValue());
                }
            } else {
                System.out.println(0);
            }
        }
    }
}
