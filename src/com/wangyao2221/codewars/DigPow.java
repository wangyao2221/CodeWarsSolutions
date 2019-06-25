package com.wangyao2221.codewars;

import java.util.Stack;

public class DigPow {

    public static long digPow(int n, int p) {
        double result = 0;

        Stack<Integer> stack = new Stack<>();
        int tmpN = n;
        int sum = 0;

        while (tmpN != 0){
            stack.push(tmpN % 10);
            tmpN /= 10;
        }

        while (!stack.empty()){
            sum += Math.pow(stack.pop(),p++);
        }

        result = sum / (n * 1.0);

        return result - (int)result == 0 ? (int)result : -1;
    }

}
