package com.feiyu.data.java_base_dome.JavaBase_2019_08_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2019/8/13  21:00
 *
 * 数组的底层实现原理：这个涉及到编译原理的问题，我只能说，这是一个编译规范。在规范中比如：int[]，
 * 中的int告诉计算机这是一个整型数据，[]告诉计算机这是一个连续存储的内存地址空间，
 * 简单点说一个连续数据的存储空间就是数组，
 *
 * 数组的移动：
 *
 * Java 里的八种基本数据结构
 *（数组（插入快，查找慢），栈（先进后出），队列（先进先出），堆（插入，删除快），
 * 链表（插入，删除快，查询慢），树(二叉树，红黑树)，图（对象的建模），哈希表）
 */
public class ArrayDome101{

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");

        Collections.max(list);
        Collections.shuffle(list);//打乱顺序

    }
}
