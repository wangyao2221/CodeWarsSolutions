package com.wangyao2221.cn.test;

import static org.junit.Assert.assertEquals;

import com.wangyao2221.cn.WrongFinder;
import org.junit.Test;

public class PathFinderTest {
    
    @Test public void sampleTests() {

      String a = ".W.\n"+
                 ".W.\n"+
                 "...",
               
             b = ".W.\n"+
                 ".W.\n"+
                 "W..",
               
             c = "......\n"+
                 "......\n"+
                 "......\n"+
                 "......\n"+
                 "......\n"+
                 "......",
               
             d = "......\n"+
                 "......\n"+
                 "......\n"+
                 "......\n"+
                 ".....W\n"+
                 "....W.";

        assertEquals(a, 4,  WrongFinder.pathFinder(a));
        assertEquals(b, -1, WrongFinder.pathFinder(b));
        assertEquals(c, 10,  WrongFinder.pathFinder(c));
        assertEquals(d, -1, WrongFinder.pathFinder(d));
    }
}

