package com.wangyao2221.codewars;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Random;

public class Psychic {

    public static double guess() {
        try {
            Class clazz = Class.forName("java.lang.Math$RandomNumberGeneratorHolder");
            Field randomNumberGeneratorField = clazz.getDeclaredField("randomNumberGenerator");
            randomNumberGeneratorField.setAccessible(true);

            Field modifersField = Field.class.getDeclaredField("modifiers");
            modifersField.setAccessible(true);
            // 把指定的field中的final修饰符去掉
            modifersField.setInt(randomNumberGeneratorField, randomNumberGeneratorField.getModifiers() & ~Modifier.FINAL);

            randomNumberGeneratorField.set(null,new Random(){
                @Override
                public double nextDouble() {
                    return 1;
                }
            });
        } catch (ClassNotFoundException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return 1;
    }

    public static void main(String[] args) {
        java.lang.Math.random();
    }
}