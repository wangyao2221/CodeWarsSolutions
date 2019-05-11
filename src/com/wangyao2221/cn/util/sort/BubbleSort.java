package com.wangyao2221.cn.util.sort;

/**
 * 可以考虑并发
 */
public class BubbleSort implements Sort {
    @Override
    public int[] sort(int[] arr,Order order) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int a = arr[j];
                int b = arr[j + 1];

                if (order == Order.DESC){
                   a = -a;
                   b = -b;
                }

                if (a > b){
                    swap(arr,j,j + 1);
                }
            }
        }

        return arr;
    }

    private void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
