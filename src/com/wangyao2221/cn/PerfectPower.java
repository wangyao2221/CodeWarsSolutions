package com.wangyao2221.cn;

public class PerfectPower {
    public static int[] isPerfectPower(int n) {
        // ...
        for (int i = 2; i <= Math.sqrt(n); i++) {
            int power = 1;
            int tmp = i;

            while (tmp < n){
                tmp *= i;
                power++;
            }

            if (tmp == n) {
                return new int[]{i,power};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] result = isPerfectPower(99999999);
        System.out.println(result[0] + " " + result[1]);
    }
}