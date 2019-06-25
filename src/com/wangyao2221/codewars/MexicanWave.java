package com.wangyao2221.codewars;

public class MexicanWave {

    public static String[] wave(String str) {
        // Your code here
        String[] result = new String[str.replace(" ","").length()];

        for (int i = 0,j = 0; i < str.length();i++) {
            char ch = str.charAt(i);
            if (ch == ' ') continue;
            String replaceCh = "" + upper(str.charAt(i));
            StringBuilder stringBuilder = new StringBuilder(str);
            result[j] = stringBuilder.replace(i,i + 1,replaceCh).toString();
            j++;
        }

        for (String s : result) {
            System.out.print(s + " ");
        }
        System.out.println();

        return result;
    }

    public static char upper(char ch){
        if (ch > 'Z'){
            ch = (char) (ch - ('a' - 'A'));
        }

        return ch;
    }

    public static void main(String[] args) {
        String[] result = new String[] { "Two words", "tWo words", "twO words", "two Words", "two wOrds", "two woRds", "two worDs", "two wordS" };
        String[] strArr = MexicanWave.wave("two words");
    }
}