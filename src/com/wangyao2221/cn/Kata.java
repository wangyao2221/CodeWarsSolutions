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
}