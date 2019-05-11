package com.wangyao2221.cn.util.sort;

public class Test {
    public static void main(String[] args) {
        int[] arr = {4,2,3,4};
        Sort sort = new BubbleSort();
        sort.sort(arr, Sort.Order.DESC);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
