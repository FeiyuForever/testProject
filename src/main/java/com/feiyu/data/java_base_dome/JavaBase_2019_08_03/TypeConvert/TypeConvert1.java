package com.feiyu.data.java_base_dome.JavaBase_2019_08_03.TypeConvert;

import com.alibaba.druid.util.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * @Author xzhou.James
 * @Date 2019/8/3  14:42
 */
public class TypeConvert1 {

    public static void main(String[] args) {
        String string = "key =Hello,World!";
        String[] stringStr = string.split("=");
        String stringStr_s = stringStr[0];
        System.out.println("取字符串的头部--->" + stringStr_s);

        String stringStr_ss = stringStr[1];
        System.out.println("取字符串的尾部--->" + stringStr_ss);
    }

    @Test
    public void TestStringConvert() {
        String string = "FiveMiles";
        char[] chars = string.toCharArray();
        char[] clone_chars = chars.clone();
        for (char chs :clone_chars) {
            System.out.println("------》"+chs);
        }
    }

    /**
     *  ++    和   -- 的区别
     */
    @Test
    public void TransportNumber(){
        int a = 10;
        int b1 = a--;
        int b2 = --a;

        System.out.println("b的值----"+b1);
        System.out.println("a的值----"+b2);

    }

}
