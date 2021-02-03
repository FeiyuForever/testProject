    package com.feiyu.data.practise.leetcode.huawei.string;

    import java.util.*;

    /**
     * Created by xzhou.James on 2021/1/24
     */
    public class LastStringLength {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line == null || line == "") {
                    System.exit(0);
                }
                if (!line.contains(" ")) {
                    System.out.println(line.length());
                    continue;
                } else {
                    String[] strings = line.split(" ");
                    String result = strings[strings.length - 1];
                    System.out.println(result.length());
                    continue;
                }
            }
        }
    }
