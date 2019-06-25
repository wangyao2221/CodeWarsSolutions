package com.wangyao2221.codewars;

import java.util.List;

public class BinaryArrayToNumber {

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int sum = 0;
        for (int i = 0; i < binary.size(); i++) {
            sum = sum << 1;
            sum = sum | binary.get(i);
        }
        return sum;
    }
}