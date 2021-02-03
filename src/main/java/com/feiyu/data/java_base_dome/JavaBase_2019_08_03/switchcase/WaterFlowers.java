package com.feiyu.data.java_base_dome.JavaBase_2019_08_03.switchcase;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author xzhou.James
 * @Date 2019/8/3  19:55
 *
 * 打印水仙花数
 */
public class WaterFlowers {

    @Test
    public void printFlowers(){

        /**
         * 循环打印 100 到1000 的水仙花数
         * 水仙花数  -- （各个位的三次方  加起来  和  等于  这个数本身）
         * for(初始化语句；判断条件语句；控制条件语句){}
         */

        List<Integer> flowers = new ArrayList<>();

        for(int x = 100;x<1000;x++){

            int ge = x%10; //取余
            int shi = x/10%10;//取余
            int bai = x/100%10;//取余

            if(Math.pow(ge,3)+Math.pow(shi,3)+Math.pow(bai,3) == x){
                flowers.add(x);
                System.out.println("100 到1000 的水仙花数-->"+x);
            }
        }

        //取最大的水仙花数
        int max = Collections.max(flowers);
        System.out.println("最大的水仙花数---"+max);

        //选择水仙花
        selectFlowers(flowers);
    }

    private void selectFlowers(List<Integer> flowers) {

        int flower = 0;

        for (Integer number:flowers) {
            //flower = number;
            switch (number){
                case 153:
                    System.out.println("我是153--最小的");
                    break;
                case 370:
                    System.out.println("我是370");
                    break;
                case 371:
                    System.out.println("我是371");
                    break;
                case 407:
                    System.out.println("我是407--最大的");
                    break;
                default:
                    System.out.println("========");
                    break;
            }
        }
    }
}
