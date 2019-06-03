package com.wangyao2221.cn.test;

import static org.junit.Assert.assertEquals;

import com.wangyao2221.cn.Finder;
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

        assertEquals(a, 4,  Finder.pathFinder(a));
        assertEquals(b, -1, Finder.pathFinder(b));
        assertEquals(c, 10,  Finder.pathFinder(c));
        assertEquals(d, -1, Finder.pathFinder(d));
    }
}

