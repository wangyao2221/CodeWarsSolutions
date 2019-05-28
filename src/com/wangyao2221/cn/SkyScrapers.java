package com.wangyao2221.cn;

import java.util.ArrayList;
import java.util.List;

public class SkyScrapers {
    static List<int[]> orders = new ArrayList<>();

    public static void main(String[] args) {
        int[] origin = {1, 2, 3, 4};

        permutate(origin, 0);

        for (int[] order : orders) {
            for (int i : order) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static int[][] solvePuzzle(int[] clues) {
        int[][] result = new int[4][4];
        int[] origin = {4, 1, 2, 3};

        permutate(origin, 0);

        for (int i = 0; i < clues.length; i++) {
            if (clues[i] == 4) {

            }
        }

        while (true) {
            break;
        }

        return new int[4][4];
    }

    static void permutate(int[] origin, int begin) {
        int length = origin.length;
        if (begin == length) {
            int[] order = origin.clone();
            orders.add(order);
        }

        for (int i = begin; i < length; i++) {
            swap(origin, begin, i);
            permutate(origin, begin + 1);
            swap(origin, begin, i);
        }
    }

    static void swap(int[] data, int left, int right) {
        int tmp = data[left];
        data[left] = data[right];
        data[right] = tmp;
    }
}
