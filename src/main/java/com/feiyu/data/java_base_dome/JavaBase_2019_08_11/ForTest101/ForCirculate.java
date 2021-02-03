package com.feiyu.data.java_base_dome.JavaBase_2019_08_11.ForTest101;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2019/8/11  16:22
 *
 * for  循环的 取值  和  设置值
 */
public class ForCirculate {

    @Test
    public void TestCieculate101(){
        List<String> list = new ArrayList<>();

        list.add("aaa");
        list.add("aaa");
        list.add("aaa");
        list.add("aaa");

        list.set(2,"bbb");

        for(int x = 0;x < list.size();x++){
            System.out.println(" "+list.get(x)+" ");
        }
        System.out.print(" ");
    }



    @Test
    public void TestCirculate102(){
        System.out.println("===================");

        long start = System.currentTimeMillis();

        int[] nums = {1,5,8,12,15,24};

        int target = 12;

        int index = -1;

        for(int x = 0;x < nums.length;x++){
            if(nums[x] == target){
                index = x;
                break;
            }
        }

        long end = System.currentTimeMillis();

        long time = end - start;

        System.out.println("找出目标值索引的位置---->"+index+ "<---- 计算的时间为 ---->"+formatDate(time)+"<---所花费的时间为--->"+time);

        System.out.println("===================");
    }

    private String formatDate(long time) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String stringDate = simpleDateFormat.format(date);
        if(stringDate != null){
            return stringDate;
        }
        return null;
    }

}
