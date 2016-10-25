package com.medibank;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by zhaoyi0113 on 25/10/2016.
 */
public class InputReader {


    private static final java.lang.String SPACE = " ";

    private static final Logger LOGGER = Logger.getLogger(InputReader.class.getName());

    /**
     * read input line and create movements list accordingly
     *
     * @param lm the string represent the input line
     * @return the list of Movement instances
     */
    public List<Movement> readMovement(String lm) {
        List<Movement> movements = new ArrayList<>();
        if (lm == null) {
            return movements;
        }
        char[] chars = lm.toCharArray();
        for (char m : chars) {
            Movement movement = new Movement(String.valueOf(m));
            movements.add(movement);
        }
        return movements;
    }

    /**
     * read the position of the given string
     *
     * @param s the input string represent a position
     * @return the Position instance; or null if the input is not correct
     */
    public Position readPosition(String s) {
        if (s == null || s.split(SPACE).length < 3) {
            LOGGER.severe("The input position string is not valid " + s);
            return null;
        }
        try {
            String[] split = s.split(SPACE);
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            Orientation orientation = Orientation.getEnum(split[2]);
            return new Position(x, y, orientation);
        } catch (IllegalArgumentException e) {
            LOGGER.severe(e.getMessage());
        }
        return null;
    }
}
