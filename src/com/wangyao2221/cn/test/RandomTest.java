package com.wangyao2221.cn.test;

import com.wangyao2221.cn.Psychic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.runners.JUnit4;


public class RandomTest {
    @Test
    public void testRandom() {
        assertEquals(Psychic.guess(), java.lang.Math.random(), 0);
    }
}