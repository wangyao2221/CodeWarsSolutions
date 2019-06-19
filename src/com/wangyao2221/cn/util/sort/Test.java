package com.wangyao2221.cn.util.sort;

public class Test {
    public static void main(String[] args) {
        int[] arr = {4,2,3,4};
        IArraySort sort = new BubbleSort();
        sort.sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
