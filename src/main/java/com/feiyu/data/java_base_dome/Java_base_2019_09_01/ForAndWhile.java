package com.feiyu.data.java_base_dome.Java_base_2019_09_01;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @Author xzhou.James
 * @Date 2019/9/1  21:37
 */
public class ForAndWhile {

    /**
     * 控制循环语句
     */
    @Test
    public void TestFor01(){
        for(char c = 0;c < 128;c++){
            if(Character.isLowerCase(c)){
                System.out.println("value-->"+(int)c+"---->"+c);
            }
        }
    }

    @Test
    public void printNumber(){
        for (int i = 0; i < 100; i++) {
            System.out.print(i+" ");
        }
    }

    @Test
    public void TestRondam(){
        Random random = new Random();
        int number = random.nextInt(25)+1;
        System.out.println(number);
        if(number > random.nextInt(25)+1){
            System.out.println(number);
        }else if(number == random.nextInt(25)+1){
            System.out.println(number);
        }else if(number < random.nextInt(25)+1){
            System.out.println(number);
        }

        System.out.println("==========================");

        int temp = 0;

        while( number > 10){
            temp = number+1;
            if(temp == 25){
                System.out.println("符合条件的数据--->"+temp);
                break;
            }
        }
    }

    @Test
    public void TestCommaOperator(){

        for (int i = 1, j = i + 10; i < 5; i++,j = i * 2) {
            System.out.println("i   "+i+"---->"+"j   "+j);
        }

    }

    @Test
    public void TestCommaOperator1(){
        String a = "100.25";
        //String b = splitString(a);
        String b = "";
        String c = "  ";
        System.out.println(b);
        System.out.println(c);
    }

    private String splitString(String a) {

        if(a.contains(",")){
            String[] result = a.split(",");
            String s = result[0];
            return s;
        }else {
            return " ";
        }
    }

    /**
     * 计算a和b的差
     */
    public static void main(String[] args) {
       /* int a=3,b=2;
        int c=a-b;
        System.out.println(c);*/
        String a  = "";
        String b  = " ";
        if(StringUtils.isEmpty(b)){

        }
        StringUtils.isEmpty(b);
        StringUtils.isBlank(b);

    }


}
