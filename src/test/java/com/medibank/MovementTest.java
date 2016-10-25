package com.medibank;

import org.junit.Assert;
import org.junit.Test;

/**
 * This class is used to test the movement of trainee
 * <p>
 * Created by zhaoyi0113 on 25/10/2016.
 */
public class MovementTest {


    @Test
    public void test_change_position_normal_cases() {
        Movement movement = new Movement("L");
        Position newPosition = movement.move(new Position(1, 1, Orientation.EAST), 3, 3);
        Assert.assertEquals(Orientation.NORTH, newPosition.getOrientation());

        movement = new Movement("R");
        newPosition = movement.move(new Position(0, 0, Orientation.NORTH), 3, 3);
        Assert.assertEquals(Orientation.EAST, newPosition.getOrientation());

        movement = new Movement("R");
        newPosition = movement.move(new Position(0, 0, Orientation.WEST), 3, 3);
        Assert.assertEquals(Orientation.NORTH, newPosition.getOrientation());


    }

    @Test
    public void test_change_position_error_cases() {
        Movement movement = new Movement("L");
        Position newPosition = movement.move(null, 3, 3);
        Assert.assertNull(newPosition);
    }

    @Test
    public void test_move_forward_normal_cases() {
        Movement movement = new Movement("M");
        Position newPosition = movement.move(new Position(1, 1, Orientation.EAST), 3, 3);
        Assert.assertNotNull(newPosition);
        Assert.assertEquals(2, newPosition.getX());

        newPosition = movement.move(new Position(5, 5, Orientation.WEST), 3, 3);
        Assert.assertNotNull(newPosition);
        Assert.assertEquals(4, newPosition.getX());

        newPosition = movement.move(new Position(1, 1, Orientation.SOUTH), 3, 3);
        Assert.assertNotNull(newPosition);
        Assert.assertEquals(0, newPosition.getY());

        newPosition = movement.move(new Position(1, 1, Orientation.NORTH), 3, 3);
        Assert.assertNotNull(newPosition);
        Assert.assertEquals(2, newPosition.getY());

        newPosition = movement.move(new Position(3, 2, Orientation.NORTH), 3, 3);
        Assert.assertNotNull(newPosition);
        Assert.assertEquals(3, newPosition.getY());
    }

    @Test
    public void test_move_forward_block_cases() {
        Movement movement = new Movement("M");
        Position newPosition = movement.move(new Position(1, 1, Orientation.EAST), 1, 1);
        Assert.assertNotNull(newPosition);
        Assert.assertEquals(1, newPosition.getX());

        newPosition = movement.move(new Position(1, 1, Orientation.NORTH), 1, 1);
        Assert.assertNotNull(newPosition);
        Assert.assertEquals(1, newPosition.getY());

    }

}
