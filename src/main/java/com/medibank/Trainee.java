package com.medibank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyi0113 on 25/10/2016.
 */
public class Trainee {

    private Position position;

    private List<Movement> movements = new ArrayList<>();

    private int maxX, maxY;

    public Trainee(Position position, List<Movement> movements, int maxX, int maxY) {
        this.position = position;
        this.movements.addAll(movements);
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void calibrate() {
        for (Movement movement : movements) {
            position = movement.move(position, maxX, maxY);
        }
    }

    public Position getPosition() {
        return position;
    }
}
