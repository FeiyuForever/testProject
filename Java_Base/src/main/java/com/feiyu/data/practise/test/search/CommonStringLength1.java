package com.feiyu.data.practise.test.search;

/**
 * @Author xzhou.James
 * @Date 2020/7/22  22:16
 *
 * 计算两个字符串的最大公共字串的长度，字符不区分大小写
 */
public class CommonStringLength1 {
    /*public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = bufferedReader.readLine()) != null){
            String second = bufferedReader.readLine();
            if(str.length() <= 0 || second.length() <= 0){
                System.out.println("请输入合法的字符串");
                continue;
            }
            int result = getResult(str,second);
            System.out.println(result);
        }
    }

    private static int getResult(String first, String second) {
        char[] chars1 = first.toCharArray();
        char[] chars2 = second.toCharArray();
        int count = 0;
        int max = 0;
        for (int i = 0; i < chars1.length ; i++) {

        }
        return 0;
    }*/

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {1,2,3};
        int[][] chars = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                System.out.print(chars[i][j]+" ");
            }
            System.out.println("\n");
        }
    }
}
