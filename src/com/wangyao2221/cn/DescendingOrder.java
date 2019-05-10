package com.wangyao2221.cn;

import java.util.*;

public class DescendingOrder {
    public static int sortDesc(final int num) {
        List<Integer> numList = new ArrayList<>();
        int temp = num;

        do {
            numList.add(temp % 10);
            temp /= 10;
        } while (temp > 0);

        int result = numList.stream().sorted(Comparator.reverseOrder()).reduce((x, y) -> x * 10 + y).get();

        return result;
    }

    public static void main(String[] args) {
        System.out.println(sortDesc(234));
    }
}