package com.feiyu.data.practise.middenrank;

/**
 * Created by xzhou.James on 2020/9/21
 */
public class MainFunction {


    /*public static void main(String[] args) {
        String[] strings = {"aaa","aab","aac"};
        String result = getResultString(strings);
        System.out.println("result = " + result);
    }

    private static String getResultString(String[] stringArray){
        if(stringArray == null || stringArray.length == 0){
            return "";
        }
        String firstWord = stringArray[0];
        int count = 0;
        String commonPrefix = "";
        for(int i = 1;i < stringArray.length;i++){
            commonPrefix = stringArray[i];
            if(firstWord.contains(commonPrefix)){
                count++;
            }else{
                getPrefixString(firstWord,commonPrefix,count);
            }
        }
        if(count == stringArray.size - 1){
            return commonPrefix;
        }else{
            return "";
        }
    }

    private static void getPrefixString(String firstWord,String commonPrefix,int count){
        byte[] bytes = commonPrefix.getBytes();
        StringBuilder sb = new StringBuilder();
        String prefixStr = sb.append(bytes[0]);
        if(commonPrefix.contain(prefixStr)){
            count++;
        }else{
            for(int i = 0;i < bytes.size();i++){
                String tempStr = String.valueOf(bytes[i]);
                sb.append(bytes[i])
            }
        }
    }*/
}
