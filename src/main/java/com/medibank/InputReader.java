package com.medibank;


import java.io.*;
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

    public List<Trainee> createTrainees(InputStream file) {
        List<Trainee> trainees = new ArrayList<>();
        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(file));
            String line = bReader.readLine();
            int maxX = 0, maxY = 0;
            if (line != null) {
                String[] split = line.split(SPACE);
                if (split != null && split.length == 2) {
                    maxX = Integer.parseInt(split[0]);
                    maxY = Integer.parseInt(split[1]);
                }
            }
            trainees = createTrainees(bReader, maxX, maxY);
        } catch (FileNotFoundException e) {
            LOGGER.severe(e.getMessage());
        } catch (IOException e) {
            LOGGER.severe(e.getMessage());
        }
        return trainees;
    }


    /**
     * create trainee list from buffered read instance
     *
     * @param bReader the reader is used to read input from input stream
     * @param maxX    the max x value of the grid system
     * @param maxY    the max y value of the grid system
     * @return Trainee list
     * @throws IOException
     */
    private List<Trainee> createTrainees(BufferedReader bReader, int maxX, int maxY) throws IOException {
        Trainee trainee = null;
        List<Trainee> trainees = new ArrayList<>();
        do {
            trainee = createTraineeFromString(bReader, maxX, maxY);
            if (trainee != null) {
                trainees.add(trainee);
            }
        } while (trainee != null);
        return trainees;
    }

    /**
     * create trainnee instance from input string
     *
     * @param bReader the reader is used to read input from input stream
     * @param maxX    the max x value of the grid system
     * @param maxY    the max y value of the grid system
     * @return Trainee object ; null if failed
     * @throws IOException
     */
    private Trainee createTraineeFromString(BufferedReader bReader, int maxX, int maxY) throws IOException {
        Trainee trainee = null;
        String line = bReader.readLine();
        Position position = null;
        if (line != null) {
            position = readPosition(line);
            if (position != null && (position.getX() > maxX || position.getY() > maxY)) {
                position = null;
            }
        }
        line = bReader.readLine();
        List<Movement> movements = null;
        if (line != null) {
            movements = readMovement(line);
        }
        if (position != null && movements != null) {
            trainee = new Trainee(position, movements, maxX, maxY);
        }
        return trainee;
    }

}
