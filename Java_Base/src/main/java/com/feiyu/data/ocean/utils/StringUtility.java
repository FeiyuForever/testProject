package com.feiyu.data.ocean.utils;

import java.util.*;

/**
 * String操作工具
 */
public class StringUtility {
    
    private final static int EAGLEINFO_MAX_LENTH = 1000;
    
    /**
     * 判断字符串是否null或者空字符串
     *
     * @param str
     *            str
     * @return boolean
     */
    public static boolean isBlank(String str) {
    
        return str == null || str.length() == 0;
    }
    
    /**
     * 判断字符串是否不为null并且不是空字符串
     *
     * @param str
     *            str
     * @return boolean
     */
    public static boolean isNotBlank(String str) {
    
        return !isBlank(str);
    }
    
    /**
     * 返回字符串格式的对象，如果obj是null则返回null
     *
     * @param obj
     *            obj
     * @return String
     */
    public static String getStringValue(Object obj) {
    
        return obj != null ? String.valueOf(obj) : null;
    }
    
    /**
     * @description 是否为空，如果为null或者""，返回false，不为空返回true
     * @author tzhang.neal
     * @param target
     *            target
     * @return boolean
     */
    public static boolean isNotEmpty(Object target) {
    
        if (target == null || "".equals(target.toString().trim()) || "null".equals(target.toString().trim())) {
            return false;
        }
        return true;
    }
    
    /**
     * @description 判断字符串是否为空，如果为空返回true
     * @author tzhang.neal
     * @param target
     *            target
     * @return boolean
     */
    public static boolean isEmpty(Object target) {
    
        return !isNotEmpty(target);
    }
    
    /**
     * 将字符串转换为double
     *
     * @param str
     *            str
     * @return double
     */
    public static double getDouble(String str) {
    
        return Double.parseDouble(str);
    }
    
    /**
     * 获取字符串精度
     *
     * @param str
     *            str
     * @return double
     */
    public static double getDoubleAccuracy(String str) {
    
        return str.substring(str.indexOf('.') + 1).length();
    }
    
    /**
     * 将字符串转换为int
     *
     * @param str
     *            str
     * @return Integer
     */
    public static Integer getInt(String str) {
    
        return Integer.parseInt(str);
    }
    
    /**
     * 将字符串转换为char
     *
     * @param str
     *            str
     * @param i
     *            i
     * @return char
     */
    public static char getChar(String str, int i) {
    
        return str.charAt(i);
    }
    
    /**
     * 将含有ascii码的字符串转换为正常字符串
     *
     * @param str
     *            str
     * @return String
     */
    public static String getAscStr(String str) {
    
        StringBuilder sb = new StringBuilder();
        String[] split = str.split(StringUtility.asciiToStr("001"));
        for (String s1 : split) {
            sb.append(",").append(s1);
        }
        return sb.substring(1);
    }
    
    /**
     * 将ASCII码转换为字符串
     *
     * @param value
     *            value
     * @return String
     */
    public static String asciiToStr(String value) {
    
        StringBuilder sbu = new StringBuilder();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }
    
    /**
     * 将含有逗号和等号的字符串转换为map（形如：a=b,c=d ==> {a=b,c=d}）
     *
     * @param str
     *            str
     * @return String
     */
    public static Map<Integer, String> getStrToMap(String str) {
    
        String ascStr = getAscStr(str);
        Map<Integer, String> map = new HashMap<Integer, String>();
        String[] split = ascStr.split(",");
        for (String s1 : split) {
            if (s1.indexOf('=') == -1 || s1.endsWith("=")) {
                continue;
            }
            map.put(Integer.parseInt(s1.split("=")[0]), s1.split("=")[1]);
        }
        return map;
    }
    
    /**
     * 将含有逗号的字符串转换为map
     *
     * @param str
     *            str
     * @return List
     */
    public static List<String> strToList(String str) {
    
        List<String> list = new ArrayList<String>();
        String[] split = str.split(",");
        for (String s1 : split) {
            list.add(s1);
        }
        return list;
    }
    
    /**
     * 首字母小写
     *
     * @param str
     *            str
     * @return String
     */
    public static String lowerFrist(String str) {
    
        if (StringUtility.isBlank(str)) {
            return null;
        }
        String lower = str.toLowerCase();
        return lower.substring(0, 1) + str.substring(1);
    }
    
    /**
     * 将传入字符串s替换为首字母小写的字符串str
     *
     * @param str
     *            原字符串
     * @param s
     *            带替换字符串
     * @return str
     */
    public static String replaceStr(String str, String s) {
    
        if (StringUtility.isBlank(str) || StringUtility.isBlank(s)) {
            return null;
        }
        String[] split = s.split(",");
        for (int i = 0; i < split.length; i++) {
            if (str.contains(split[i])) {
                str = str.replace(split[i], lowerFrist(split[i]));
            }
            
        }
        return str;
    }
    
    /**
     * 截取第n次出现str的字符串
     *
     * @param str
     *            原始字符串
     * @param b
     *            出现的字符串
     * @param n
     *            第几次出现
     * @return String
     */
    public static String getSubOnceNStr(String str, String b, int n) {
    
        int i = 0;
        int s = 0;
        while (i++ < n) {
            s = str.indexOf(b, s + 1);
            if (s == -1) {
                return str;
            }
        }
        return str.substring(s);
    }
    
    /**
     * 获取EL表达式集合
     *
     * @param expressionString
     *            待解析的EL字符串
     * @param prefix
     *            前缀
     * @param suffix
     *            后缀
     * @return EL表达式集合
     */
    public static List<String> getExpressions(String expressionString, String prefix, String suffix) {
    
        List<String> expressions = new ArrayList<String>();
        int startIndex = 0;
        while (startIndex < expressionString.length()) {
            int prefixIndex = expressionString.indexOf(prefix, startIndex);
            if (prefixIndex == -1) {
                break;
            }
            int afterPrefixIndex = prefixIndex + prefix.length();
            int suffixIndex = skipToCorrectEndSuffix(suffix, expressionString, afterPrefixIndex);
            String expr = expressionString.substring(prefixIndex, suffixIndex + 1);
            expr = expr.trim();
            expressions.add(expr);
            startIndex = suffixIndex + suffix.length();
        }
        return expressions;
    }
    
    /**
     * 获取结尾字符串的位置序号
     *
     * @param suffix
     *            结尾字符
     * @param expressionString
     *            待解析的EL字符串
     * @param afterPrefixIndex
     *            前缀字符后第一个字符的位置序号
     * @return 结尾字符串的位置序号
     */
    private static int skipToCorrectEndSuffix(String suffix, String expressionString, int afterPrefixIndex) {
    
        int pos = afterPrefixIndex;
        int maxlen = expressionString.length();
        int nextSuffix = expressionString.indexOf(suffix, afterPrefixIndex);
        if (nextSuffix == -1) {
            return -1;
        }
        Stack<String> stack = new Stack<String>();
        while (pos < maxlen) {
            if (isSuffixHere(expressionString, pos, suffix) && stack.isEmpty()) {
                break;
            }
            char ch = expressionString.charAt(pos);
            switch (ch) {
                case '{':
                    stack.push("{");
                    break;
                case '}':
                    stack.pop();
                    break;
                default:
                    break;
            }
            pos++;
        }
        if (!stack.isEmpty()) {
            return -1;
        }
        return pos;
    }
    
    /**
     * 判断是否是结尾字符串
     *
     * @param expressionString
     *            待解析的EL字符串
     * @param pos
     *            位置
     * @param suffix
     *            结尾字符串
     * @return boolean
     */
    private static boolean isSuffixHere(String expressionString, int pos, String suffix) {
    
        int suffixPosition = 0;
        for (int i = 0; i < suffix.length() && pos < expressionString.length(); i++) {
            if (expressionString.charAt(pos++) != suffix.charAt(suffixPosition++)) {
                return false;
            }
        }
        if (suffixPosition != suffix.length()) {
            return false;
        }
        return true;
    }
    
    /**
     * 将个数为1的数字转为首位为0的两位字符串
     *
     * @param num
     *            num
     * @return String
     */
    public static String numToContainsZeroStr(int num) {
    
        if (String.valueOf(num).length() >= 2) {
            return String.valueOf(num);
        }
        return "0" + num;
    }
    
    /**
     * 日志内容字符串传输到Eagle最大4K
     *
     * @param oriStr
     *            oriStr
     * @return str
     */
    public static String getEagleString(String oriStr) {
    
        String destStr = oriStr;
        if (destStr == null) {
            return null;
        }
        if (oriStr.length() > EAGLEINFO_MAX_LENTH) {
            destStr = destStr.substring(0, EAGLEINFO_MAX_LENTH - 1);
        }
        return destStr;
    }
    
    // public static void main(String[] args) {
    //
    // System.out.println(getEagleString(null));
    // System.out.println(getEagleString("abc"));
    // StringBuffer str = new StringBuffer();
    // for (int i = 0; i < 900; i++) {
    // str.append("test");
    // str.append(i);
    // }
    // System.out.println(getEagleString(str.toString()));
    // }
    
}
