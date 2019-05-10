package com.wangyao2221.cn;

public class Square {
    public static boolean isSquare(int n) {
        int sqrtN = (int) sqrt(n);
        if ((sqrtN * sqrtN) == n) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(isSquare(2));
//        System.out.println(sqrt(-1));
    }

    public static double sqrt(double n){
        double x = n;
        double err = 1e-15;
        while ((x - n / x) > err){
            x = (x + n / x) / 2;
        }
        return x;
    }
}
