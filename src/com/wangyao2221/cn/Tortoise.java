package com.wangyao2221.cn;

import java.util.Arrays;

public class Tortoise {
    public static int[] race(int v1, int v2, int g) {
        // your code
        if (v1 > v2) {
            return null;
        }

        double time = g / (double)(v2 - v1) * 3600;
        int hour = (int)time / 3600;
        time = time % 3600;
        int minute = (int)time / 60;
        int sec = (int)time % 60;

        return new int[]{hour,minute,sec};
    }
}