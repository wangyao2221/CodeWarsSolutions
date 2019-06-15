package com.wangyao2221.cn.util.sort;

public class QuickSort {
    public static void main(String[] args) {
       int[] arr = {5,1,9,2,4,8,7};
       new QuickSort().quickSort(arr,0,arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void quickSort(int[] arr,int low,int high){
        if (low < high) {
            int povit = partition(arr,low,high);
            quickSort(arr,low,povit - 1);
            quickSort(arr,povit + 1,high);
        }
    }

    public int partition(int[] arr,int low,int high){
        int  povit = arr[low];

        while(low < high){
            while (low < high && arr[high] >= povit){
                high--;
            }

            arr[low] = arr[high];
            while (low < high && arr[low] <= povit){
                low++;
            }

            arr[high] = arr[low];
        }

        arr[low] = povit;
        return low;
    }
}
