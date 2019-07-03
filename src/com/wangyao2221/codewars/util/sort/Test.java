package com.wangyao2221.codewars.util.sort;

public class Test {
    public static void main(String[] args) {
        int[] sourceArray = {5,2,7,3,6,1,4};
        int[] arr = new HeapSort().sort(sourceArray);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
