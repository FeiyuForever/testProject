package com.feiyu.data.practise.test.other;

import java.util.*;

/**
 * @Author xzhou.James
 * @Date 2020/7/14  21:56
 * <p>
 * 冒泡排序
 */
public class BubblingSort {

    public static void main(String[] args) {
        String temp = "aabbabcccbbc";
        Map<Character, Integer> map = getResultChar(temp);
        Map<Integer, Character> newMap = new TreeMap<Integer, Character>();
        Set<Character> set = map.keySet();
        for (Character elem : set) { //abc 354
            int element = map.get(elem);
            newMap.put(element, elem);
        }
        //按照次数的大小进行排序
        executorMap(newMap);
    }

    private static void executorMap(Map<Integer, Character> newMap) {
        try {
            Set<Integer> set = newMap.keySet();
            List<Integer> list = new ArrayList<>();
            for (Integer elem : set) {
                list.add(elem);
            }
            convertSort(list, newMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void convertSort(List<Integer> list, Map<Integer, Character> newMap) {
        //a b c   |   3 5 4  -> a c b
        Integer[] tempArray = list.toArray(new Integer[list.size()]);
        int lengths = newMap.size();
        boolean flag = true;
        while(flag){
            flag = false;
            for (int j = 0; j < lengths; j++) {
                if (tempArray[j] > tempArray[j + 1]) {
                    int array = tempArray[j];
                    tempArray[j] = tempArray[j + 1];
                    tempArray[j + 1] = array;
                    flag = true;
                }
                lengths--;
            }
        }

        for (int i = 0; i < tempArray.length; i++) {
            System.out.print(newMap.get(tempArray[i]));
        }
    }

    private static Map<Character, Integer> getResultChar(String temp) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chars = temp.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char first = chars[i];
            if (!map.containsKey(first)) {
                map.put(first, 1);
            } else {
                int total = map.get(first);
                total += 1;
                map.remove(first);
                map.put(first, total);
            }
        }
        return map;
    }
}
