package com.wangyao2221.codewars.util.permutation_combinaton;

import java.util.ArrayList;
import java.util.List;

public abstract class Permutation {
    List<Object[]> orders;

    public Permutation() {
        this.orders = new ArrayList<>();
    }

    public void permutate(Object[] origin,int begin){
        int length = origin.length;
        if (begin == length) {
            Object[] order = origin.clone();
            orders.add(order);
        }

        Object obj = new Object();

        for (int i = begin; i < length; i++) {
            swap(origin,begin,i);
            permutate(origin,begin + 1);
            swap(origin,begin,i);
        }
    }

    private static void swap(Object[] data,int left,int right){
        Object tmp = data[left];
        data[left] = data[right];
        data[right] = tmp;
    }

    public List<Object[]> getOrders() {
        return orders;
    }
}
