package com.feiyu.data.practise.test.other;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author xzhou.James
 * @Date 2020/7/21  22:03
 *
 * 计算  --  x轴和y轴，从左上角到右下角的路线
 */
public class CeilFunction {
    public static void main(String[] args) throws Exception{
        BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = bReader.readLine()) != null) {
            String[] arrays = line.split(" ");
            int n =Integer.valueOf(arrays[0]);
            int m =Integer.valueOf(arrays[1]);
            System.out.println(getResult(n, m));
        }
    }

    private static int getResult(int n, int m) {
        int[][] lines = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if(i == 0 || j == 0){
                    lines[i][j] = 1;
                }else{
                    lines[i][j] = lines[i][j-1] + lines[i-1][j];
                }
            }
        }
        return lines[n][m];
    }
}
