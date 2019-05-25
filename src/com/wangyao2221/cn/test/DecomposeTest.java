package com.wangyao2221.cn.test;

import static org.junit.Assert.*;

import com.wangyao2221.cn.Decompose;
import org.junit.Test;


public class DecomposeTest {

    @Test
    public void test1() {
        Decompose d = new Decompose();
        long n = 11;
        assertEquals("1 2 4 10", d.decompose(n));
    }

    @Test
    public void test2() {
        Decompose d = new Decompose();
        long n = 12;
        assertEquals("1 2 3 7 9", d.decompose(n));
    }

    @Test
    public void test3() {
        Decompose d = new Decompose();
        long n = 50;
        assertEquals("1 3 5 8 49", d.decompose(n));
    }
}
