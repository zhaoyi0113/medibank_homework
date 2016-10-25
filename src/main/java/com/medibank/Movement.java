package com.medibank;

/**
 * Created by zhaoyi0113 on 25/10/2016.
 */
public class Movement {

    private static final String LEFT = "L";
    private static final String RIGHT = "R";
    private static final String MOVE = "M";

    private String operation;

    public Movement(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    /**
     * move the position based on current orientation
     *
     * @param position the position
     * @return the new position after the movement
     */
    public Position move(Position position, int maxX, int maxY) {
        Position newPosition = null;
        if (position == null) {
            return newPosition;
        }
        if (LEFT.equals(operation)) {
            newPosition = new Position(position.getX(), position.getY(), position.getOrientation().previous());
        } else if (RIGHT.equals(operation)) {
            newPosition = new Position(position.getX(), position.getY(), position.getOrientation().next());
        } else if (MOVE.equals(operation)) {
            newPosition = moveForward(position, maxX, maxY);
        }
        return newPosition;
    }

    /**
     * make a forward movement based on the posistion
     *
     * @param position the current posistion
     * @return the new posisiton after move
     */
    private Position moveForward(Position position, int maxX, int maxY) {
        int x = position.getX();
        int y = position.getY();
        switch (position.getOrientation()) {
            case EAST:
                if (x < maxX) {
                    x++;
                }
                break;
            case SOUTH:
                if (y > 0) {
                    y--;
                }
                break;
            case WEST:
                if (x > 0) {
                    x--;
                }
                break;
            case NORTH:
                if (y < maxY) {
                    y++;
                }
                break;
        }
        return new Position(x, y, position.getOrientation());
    }


}
