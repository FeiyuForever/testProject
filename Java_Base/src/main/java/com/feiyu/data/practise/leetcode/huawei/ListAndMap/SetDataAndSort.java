package com.feiyu.data.practise.leetcode.huawei.ListAndMap;

import java.util.*;

/**
 * Created by xzhou.James on 2021/1/24
 * <p>
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数
 * （N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。
 * 然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作
 * (同一个测试用例里可能会有多组数据，希望大家能正确处理)。
 * <p>
 * <p>
 * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
 * <p>
 * 当没有新的输入时，说明输入结束。
 * <p>
 * 输入描述:
 * 注意：输入可能有多组数据。每组数据都包括多行，第一行先输入随机整数的个数N，接下来的N行再输入相应个数的整数。
 * 具体格式请看下面的"示例"。
 */
public class SetDataAndSort {

    private static Map<Integer, TreeSet<Integer>> map = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int key = scanner.nextInt();
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < key; i++) {
                set.add(scanner.nextInt());
            }
            set.stream().forEach(s -> System.out.println(s));
        }
    }

    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNext("#")) {
            int key = scanner.nextInt();
            if (key == 0) {
                continue;
            }
            List<Integer> list = new ArrayList<>();
            Scanner scannerIn = new Scanner(System.in);
            while (scannerIn.hasNext()) {
                int num = scannerIn.nextInt();
                list.add(num);
                if(list.size() == key){
                    break;
                }
            }
            map.put(key, new TreeSet<>(list));
        }
        printLnNum();
    }

    public static void printLnNum() {
        Collection<TreeSet<Integer>> collection = map.values();
        for (TreeSet<Integer> elem : collection) {
            for (Integer element : elem) {
                System.out.println(element);
            }
        }
    }*/
}































