package com.wangyao2221.codewars;

public class BuyCar {

    public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
        // your code
        int[] result = new int[2];
        int months = 0;
        double priceOld = startPriceOld;
        double priceNew = startPriceNew;
        double saveMoney = 0;

        while (saveMoney + priceOld < priceNew){
            saveMoney += savingperMonth;
            priceOld -= priceOld * percentLossByMonth / 100;
            priceNew -= priceNew * percentLossByMonth / 100;
            months++;
            percentLossByMonth += 0.5 * (months % 2);
        }


        int leftMoney = (int) Math.round(saveMoney + priceOld - priceNew);

        result[0] = months;
        result[1] = leftMoney;

        return result;
    }
}