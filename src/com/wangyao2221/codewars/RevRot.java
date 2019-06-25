package com.wangyao2221.codewars;

public class RevRot {
    
    public static String revRot(String strng, int sz) {
        // your code
        if(sz <= 0) return "";
        if (sz > strng.length()) return "";

        StringBuilder result = new StringBuilder();
        StringBuilder rem = new StringBuilder(strng);

        for (int i = 0;rem.length() >= sz; i++) {
            String tempStr = rem.substring(0,sz);
            int sum = 0;

            for (int j = 0; j < tempStr.length(); j++) {
                int cur = tempStr.charAt(j) - '0';
                sum += cur * cur * cur;
            }

            if (sum % 2 == 0){
                result.append(reverse(tempStr));
            }else {
                result.append(rotateLeftOne(tempStr));
            }

            rem.delete(0,sz);
        }

        return result.toString();
    }

    public static String rotateLeftOne(String str){
        StringBuilder stringBuilder = new StringBuilder(str);
        char ch = stringBuilder.charAt(0);

        stringBuilder.delete(0,1).append(ch);

        return stringBuilder.toString();
    }

    public static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }
}