package com.wangyao2221.cn;

public class DuplicateEncode {

    public static void encode(String str){
        int[] arr = new int[127];

        str = str.toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            arr[index]++;
        }

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            if (arr[index] > 1){
                System.out.print(")");
            }else {
                System.out.print("(");
            }
        }

        System.out.println();
    }

    public static void main(String[] args) {
        encode("Success");
    }
}
