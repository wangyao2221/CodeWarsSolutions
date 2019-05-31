package com.wangyao2221.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.codewars.com/kata/5671d975d81d6c1c87000022/train/java
public class SkyScrapers {
    static List<int[]> orders = new ArrayList<>();
    static List<int[]>[] ordersClassify = new ArrayList[4];
    static Map<Integer, Integer> map = new HashMap<Integer, Integer>() {
        {
            put(0, 0);
            put(1, 1);
            put(2, 2);
            put(3, 3);
            put(4, 3);
            put(5, 7);
            put(6, 11);
            put(7, 15);
            put(8, 15);
            put(9, 14);
            put(10, 13);
            put(11, 12);
            put(12, 12);
            put(13, 8);
            put(14, 4);
            put(15, 0);
        }
    };

    public static void main(String[] args) {
        int clues[][] = {
                {2, 2, 1, 3,
                        2, 2, 3, 1,
                        1, 2, 2, 3,
                        3, 2, 1, 3},
                {0, 0, 1, 2,
                        0, 2, 0, 0,
                        0, 3, 0, 0,
                        0, 1, 0, 0}
        };
        solvePuzzle(clues[0]);

//        permutate(clues, 0);
//        genOrdersClassify();

//        for (int[] order : orders) {
//            for (int i : order) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
    }

    static int[][] solvePuzzle(int[] clues) {
        int[][] result = new int[4][4];
        int[] origin = {4, 1, 2, 3};

        permutate(origin, 0);
        genOrdersClassify();
        findFourPosition(clues, result);

        while (true) {
            break;
        }

        return new int[4][4];
    }

    static void findFourPosition(int[] clues, int[][] result) {
        for (int i = 0; i < clues.length; i++) {
            if (clues[i] == 1) {
                int index = map.get(i);
                result[index / 4][index % 4] = 4;
            }
        }

        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    static void genOrdersClassify() {
        for (int i = 0; i < ordersClassify.length; i++) {
            ordersClassify[i] = new ArrayList<>();
        }

        for (int[] order : orders) {
            for (int i = 0; i < order.length; i++) {
                if (order[i] == 4) {
                    ordersClassify[i].add(order);
                }
            }
        }

//        for (List<int[]> ints : ordersClassify) {
//            for (int[] anInt : ints) {
//                for (int i : anInt) {
//                    System.out.print(i + " ");
//                }
//                System.out.println();
//            }
//        }
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
