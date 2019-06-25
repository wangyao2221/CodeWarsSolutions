package com.wangyao2221.codewars;

import java.util.ArrayList;

public class Metro {

    public static int countPassengers(ArrayList<int[]> stops) {
        //Code here!
        int sum = 0;
        for (int[] stop : stops) {
            sum += stop[0] - stop[1];
        }

        return sum;
    }
}