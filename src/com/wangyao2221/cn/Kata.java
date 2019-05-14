package com.wangyao2221.cn;

import java.util.Arrays;

public class Kata {
    public static int findShort(String s) {
        int length = Integer.MAX_VALUE;
        String[] sArr = s.split(" ");

        for (String s1 : sArr) {
            if (s1.length() < length){
                length = s1.length();
            }
        }

        return length;
    }

    public static String high(String s) {
        // Your code here...
        String[] sArr = s.split(" ");
        String result = sArr[0];
        int score = 0;

        for (String s1 : sArr) {
            int temp_score = 0;

            for (int i = 0; i < s1.length(); i++) {
                temp_score += s1.charAt(i) - 'a';
            }

            System.out.println(s1 + ":" + temp_score);

            if (temp_score > score){
                score = temp_score;
                result = s1;
            }
        }
        return result;
    }
}