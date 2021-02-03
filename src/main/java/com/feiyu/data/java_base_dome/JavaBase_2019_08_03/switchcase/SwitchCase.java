package com.feiyu.data.java_base_dome.JavaBase_2019_08_03.switchcase;

/**
 * @Author xzhou.James
 * @Date 2019/8/3  16:41
 */
public class SwitchCase {

    public static int Switch(int number){
        switch (number){
            case 1:
                number = 1001;
                break;
            case 2:
                number = 1002;
                break;
            case 3:
                number = 1003;
                break;
            default:
                number = 1000;
                break;
        }
        return number;
    }

    public static void main(String[] args) {
        int a = Switch (1);
        System.out.println("a-----"+a);
    }
}
