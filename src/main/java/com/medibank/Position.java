package com.medibank;

/**
 * This class represents a trainee's position
 *
 * Created by zhaoyi0113 on 25/10/2016.
 */
public class Position {

    /**
     * the x value in the current coordinates  system
     */
    private int x;

    /**
     * the y value in the current coordinates  system
     */
    private int y;

    /**
     * the orientation
     */
    private Orientation orientation;

    public Position(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Orientation getOrientation() {
        return orientation;
    }


}