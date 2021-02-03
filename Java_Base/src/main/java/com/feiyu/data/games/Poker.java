package com.feiyu.data.games;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @Author xzhou.James
 * @Date 2020/8/29  10:57
 *
 * 制造牌  和 打乱牌顺序
 */
public class Poker {

    /**
     * 存放所有的扑克牌
     */
    private static LinkedList<String> allPoker = new LinkedList<String>();
    /**
     * 索引
     */
    private Integer index;

    public LinkedList<String> getAllPoker() {
        return allPoker;
    }

    public void setAllPoker(LinkedList<String> allPoker) {
        this.allPoker = allPoker;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * 制造牌和洗牌
     */
    public static LinkedList<String> makePoker() {
        String[] type = {"A", "B", "C", "D"};
        for (int i = 0; i < type.length; i++) {
            for (int j = 1; j <= 13; j++) {
                String elem = String.valueOf(j + type[i]);
                allPoker.add(elem);
            }
        }
        Collections.shuffle(allPoker);
        return allPoker;
    }
}