package com.feiyu.data.practise.test.other;

/**
 * @Author xzhou.James
 * @Date 2020/7/9  21:06
 * <p>
 * 最小公倍数
 */
public class Minimum {

        public static void main(String[] args){
            int a = 5,b = 7;
            int result = getMinimam(a,b);
        }

        private static int getMinimam(int a,int b){
            int resultNum = 0;
            if(a == b){
                return a;
            }else{
                if(a > b && a % b == 0){
                    return a;
                }
                if(a < b && b % a == 0){

                }
            }
            return resultNum;
        }
}
