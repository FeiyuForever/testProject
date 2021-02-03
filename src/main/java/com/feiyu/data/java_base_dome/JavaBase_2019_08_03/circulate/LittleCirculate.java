package com.feiyu.data.java_base_dome.JavaBase_2019_08_03.circulate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2019/8/3  20:38
 *
 * 几种循环的 判断 和  学习
 */
public class LittleCirculate {

    public void For_Circulate(List<String> word){

        for(int i = 0;i<word.size();i++){
            System.out.println("原生态的for循环-----"+word.get(i));
        }

        System.out.println("=================================");

        for (String string:word) {
            System.out.println("增强的for循环-------"+string);
        }

        System.out.println("==================================");

        while(word != null){
            if(word.get(2).equals("独角戏")){
                System.out.println("while循环的独角戏------"+word.get(2));
                break;
                //continue;
            }
        }

        /**
         * do while循环
         */
        do{
            if(word.get(2).equals("独角戏")){
                System.out.println("我是 do while循环 ---"+word.get(4));
                break;
            }
        }while((!word.isEmpty()) && word.get(4).equals("我只在乎你"));
    }

    @Test
    public void CirculateDome(){

        List<String> word = new ArrayList<>();
        word.add("月满西楼");
        word.add("今朝有酒今朝醉");
        word.add("独角戏");
        word.add("台北的机场");
        word.add("我只在乎你");
        word.add("最浪漫的事");
        word.add("十字路口");
        For_Circulate(word);
    }


    /**
     * while循环   事例
     *
     * 打印  九九  乘法表
     */
    @Test
    public void TestWhileCirculate(){

        for(int x = 1;x<=9;x++){
            for(int y = 1;y<=9;y++){
                int number = x * y;
                System.out.print(" "+number+" ");
            }
        }
    }

    /**
     * 实现输出从1—10分别乘以10所得的乘法表。
     */
    @Test
    public void NumberMoreCirculate(){
        int index = 1;
        int number;
        while (index <= 10){
            number = index * 10;
            System.out.print(" \n"+number);
            index ++;
        }
    }

}
