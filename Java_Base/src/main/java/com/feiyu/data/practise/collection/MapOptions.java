package com.feiyu.data.practise.collection;

import java.util.*;

/**
 * Created by xzhou.James on 2020/8/30
 */
public class MapOptions {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("A",14);
        map.put("B",15);
        map.put("C",18);
        map.put("D",10);
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Iterator<Map.Entry<String,Integer>> iterator = list.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> elem = iterator.next();
            System.out.println("elem = " + elem.getValue());
        }
    }
}
