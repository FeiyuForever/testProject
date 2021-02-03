package com.feiyu.data.practise.middenrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by xzhou.James on 2020/10/1
 *
 * 使用比较器排序
 */
public class ListCompareSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,5,4,9,0,15,96,155,1);
        getResultSort(list);
        for (Integer ele:list) {
            System.out.println(ele+"\t");
        }
    }

    private static void getResultSort(List<Integer> list) {
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //前一个减后一个是升序  | 否则降序
                return o1-o2;
            }
        });
    }
}
