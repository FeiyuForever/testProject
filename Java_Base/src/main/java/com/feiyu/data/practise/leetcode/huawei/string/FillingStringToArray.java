package com.feiyu.data.practise.leetcode.huawei.string;

import org.junit.Test;
import org.springframework.test.context.TestPropertySource;

import java.util.*;

/**
 * Created by xzhou.James on 2021/1/24
 *
 * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class FillingStringToArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                continue;
            }
            String[] result = getArray(line);
            for (String elem:result) {
                System.out.println(elem);
            }
        }
    }

    private static String[] getArray(String line) {
        List<String> list = new ArrayList<>();
        if(line.length() < 8){
            String newString = getResultString(line);
            list.add(newString);
        }else if(line.length() > 8){
            String newLine = line;
            while (newLine.length() > 8){
                list.add(newLine.substring(0,8));
                newLine = newLine.replaceFirst(newLine.substring(0,8),"");
            }
            String resultString = getResultString(newLine);
            list.add(resultString);
        }else{
            return new String[]{line};
        }
        return list.toArray(new String[]{});
    }

    private static String getResultString(String newLine) {
        StringBuilder sb = new StringBuilder();
        sb.append(newLine);
        int length = 8 - newLine.length();
        for (int i = 0; i < length; i++) {
            sb.append("0");
        }
        return sb.toString();
    }

    @Test
    public void TestString(){
        String a = "adsadasdasdsad";
        while (a.length() >= 8){
            a.substring(0,8);
            a = a.substring(8);
        }
    }
}
