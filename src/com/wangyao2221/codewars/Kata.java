package com.wangyao2221.codewars;

import java.util.Arrays;
import java.util.Stack;

public class Kata {
    public static int findShort(String s) {
        int length = Integer.MAX_VALUE;
        String[] sArr = s.split(" ");

        for (String s1 : sArr) {
            if (s1.length() < length){
                length = s1.length();
            }
        }

        return length;
    }

    public static String high(String s) {
        // Your code here...
        String[] sArr = s.split(" ");
        String result = sArr[0];
        int score = 0;

        for (String s1 : sArr) {
            int temp_score = 0;

            for (int i = 0; i < s1.length(); i++) {
                temp_score += s1.charAt(i) - 'a';
            }

            System.out.println(s1 + ":" + temp_score);

            if (temp_score > score){
                score = temp_score;
                result = s1;
            }
        }
        return result;
    }

    public static String createPhoneNumber(int[] numbers) {
        String numbersStr = Arrays.toString(numbers);
        numbersStr = numbersStr.replace(", ","");
        numbersStr = numbersStr.replace("[","");
        numbersStr = numbersStr.replace("]","");
        StringBuilder stringBuilder = new StringBuilder(numbersStr);
        stringBuilder.insert(6,"-");
        stringBuilder.insert(3,") ");
        stringBuilder.insert(0,"(");

        return stringBuilder.toString();
    }

    public static String longToIP(long ip) {
        // Java doesn't have uint32, so here we use long to represent int32
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        while (ip > 0){
            stack.push((int) (ip % 2));
            ip /= 2;
        }

        while (stack.size() < 32){
            stack.push(0);
        }

        int flag = 0;
        int tmp = 0;

        while (!stack.empty()){
            tmp = tmp * 2 + stack.pop();
            flag++;
            if (flag % 8 == 0){
                stringBuilder.append(tmp);
                if (flag < 32){
                    stringBuilder.append('.');
                }
                tmp = 0;
            }
        }

        return stringBuilder.toString(); // do it!
    }

}