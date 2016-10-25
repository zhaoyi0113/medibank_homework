package com.medibank;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the test class for Orientation enum
 * <p>
 * Created by zhaoyi0113 on 25/10/2016.
 */
public class OrientationTest {

    @Test
    public void test_orientation_next() {
        Assert.assertEquals(Orientation.SOUTH, Orientation.EAST.next());
        Assert.assertEquals(Orientation.WEST, Orientation.SOUTH.next());
        Assert.assertEquals(Orientation.NORTH, Orientation.WEST.next());
        Assert.assertEquals(Orientation.EAST, Orientation.NORTH.next());
    }

    @Test
    public void test_orientation_previous() {
        Assert.assertEquals(Orientation.NORTH, Orientation.EAST.previous());
        Assert.assertEquals(Orientation.EAST, Orientation.SOUTH.previous());
        Assert.assertEquals(Orientation.SOUTH, Orientation.WEST.previous());
        Assert.assertEquals(Orientation.WEST, Orientation.NORTH.previous());
    }
}
