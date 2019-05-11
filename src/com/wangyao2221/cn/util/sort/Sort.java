package com.wangyao2221.cn.util.sort;

public interface Sort {
    enum Order{
        ASC,DESC
    }

    public abstract int[] sort(int[] arr,Order order);
}
