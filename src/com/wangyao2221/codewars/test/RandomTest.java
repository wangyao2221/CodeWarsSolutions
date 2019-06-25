package com.wangyao2221.codewars.test;

import com.wangyao2221.codewars.Psychic;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RandomTest {
    @Test
    public void testRandom() {
        assertEquals(Psychic.guess(), java.lang.Math.random(), 0);
    }
}