package com.medibank;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Test cases for input line reader class
 * <p>
 * Created by zhaoyi0113 on 25/10/2016.
 */
public class InputReaderTest {

    @Test
    public void test_read_movement_normal_cases() {

        InputReader inputReader = new InputReader();
        List<Movement> movements = inputReader.readMovement("LMRL");

        Assert.assertEquals(4, movements.size());
        Assert.assertEquals("L", movements.get(0).getOperation());
        Assert.assertEquals("M", movements.get(1).getOperation());
        Assert.assertEquals("R", movements.get(2).getOperation());
        Assert.assertEquals("L", movements.get(3).getOperation());
    }

    @Test
    public void test_read_movement_error_cases() {
        InputReader reader = new InputReader();
        List<Movement> movements = reader.readMovement("");
        Assert.assertNotNull(movements);
        Assert.assertEquals(0, movements.size());
        movements = reader.readMovement(null);
        Assert.assertNotNull(movements);
        Assert.assertEquals(0, movements.size());
    }

    @Test
    public void test_read_position_normal_cases() {
        InputReader reader = new InputReader();
        Position position = reader.readPosition("1 2 N");
        Assert.assertNotNull(position);
        Assert.assertEquals(1, position.getX());
        Assert.assertEquals(2, position.getY());
        Assert.assertEquals(Orientation.NORTH, position.getOrientation());

        position = reader.readPosition("0 1 S");
        Assert.assertNotNull(position);
        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(1, position.getY());
        Assert.assertEquals(Orientation.SOUTH, position.getOrientation());


        position = reader.readPosition("10 1 w");
        Assert.assertNotNull(position);
        Assert.assertEquals(10, position.getX());
        Assert.assertEquals(1, position.getY());
        Assert.assertEquals(Orientation.WEST, position.getOrientation());
    }

    @Test
    public void test_read_position_error_cases() {
        InputReader reader = new InputReader();
        Position position = reader.readPosition("");
        Assert.assertNull(position);

        position = reader.readPosition("1 2");
        Assert.assertNull(position);

        position = reader.readPosition("12N");
        Assert.assertNull(position);

        position = reader.readPosition("1N");
        Assert.assertNull(position);

        position = reader.readPosition("A");
        Assert.assertNull(position);
    }


    @Test
    public void test_trainnee_movement_normal_case() {
        InputReader reader = new InputReader();
        List<Trainee> trainees = reader.createTrainees(getClass().getResourceAsStream("test_data.txt"));
        Assert.assertEquals(2, trainees.size());
        Trainee firstTrainee = trainees.get(0);
        Assert.assertEquals(1, firstTrainee.getPosition().getX());
        Assert.assertEquals(2, firstTrainee.getPosition().getY());
        Assert.assertEquals(Orientation.NORTH, firstTrainee.getPosition().getOrientation());

        Trainee secondTrainee = trainees.get(1);
        Assert.assertEquals(3, secondTrainee.getPosition().getX());
        Assert.assertEquals(3, secondTrainee.getPosition().getY());
        Assert.assertEquals(Orientation.EAST, secondTrainee.getPosition().getOrientation());

        firstTrainee.calibrate();
        Assert.assertEquals(1, firstTrainee.getPosition().getX());
        Assert.assertEquals(3, firstTrainee.getPosition().getY());
        Assert.assertEquals(Orientation.NORTH, firstTrainee.getPosition().getOrientation());

        secondTrainee.calibrate();
        Assert.assertEquals(5, secondTrainee.getPosition().getX());
        Assert.assertEquals(1, secondTrainee.getPosition().getY());
        Assert.assertEquals(Orientation.EAST, secondTrainee.getPosition().getOrientation());

    }

    @Test
    public void test_create_trainee_error_case() {
        InputReader reader = new InputReader();
        List<Trainee> trainees = reader.createTrainees(getClass().getResourceAsStream("error_data.txt"));
        Assert.assertEquals(0, trainees.size());

    }

}
