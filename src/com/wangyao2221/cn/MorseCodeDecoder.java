package com.wangyao2221.cn;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeDecoder {
    public static String decodeBits(String bits) {
        Map<String, String> bitToMorse = new HashMap<String, String>() {
            {
                put("0000"," ");
                put("1100","·");
                put("1111","−");
            }
        };
        StringBuilder morseCode = new StringBuilder();

        while (bits.length() >= 4) {
            String bit = bits.substring(0,4);
            morseCode.append(bitToMorse.get(bit));
            bits = bits.substring(4,bits.length());
        }

        return morseCode.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011"));
    }
}