package com.wangyao2221.cn;

// If no valid solution exists return null
public class Decompose {

    public String decompose(long n) {
        for (long i = n - 1;i > 1;i--){
            long squareRem = n * n;
            StringBuilder stringBuilder = new StringBuilder();

            for (long j = i; j > 0; j--) {
                if (j * j < squareRem){
                    stringBuilder.insert(0, " " + j);
                    squareRem -= j * j;
                }else if (j * j == squareRem){
                    stringBuilder.insert(0,j);
                    return stringBuilder.toString();
                }
            }
        }

        return null;
    }
}