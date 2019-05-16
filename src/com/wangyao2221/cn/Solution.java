package com.wangyao2221.cn;

public class Solution {

    public static String camelCase(String str) {
        // your code here
        String[] strArr = str.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : strArr) {
            if (s.length() == 0) continue;;

            char ch = s.charAt(0);

            ch = upper(ch);

            stringBuilder.
                    append(ch).
                    append(s.substring(1,s.length()));
        }

        return stringBuilder.toString();
    }

    public static char upper(char ch){
        if (ch > 'Z'){
            ch = (char) (ch - ('a' - 'A'));
        }

        return ch;
    }
}
