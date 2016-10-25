package com.medibank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * This is the main class of this program
 *
 * Created by zhaoyi0113 on 25/10/2016.
 */
public class Calibrator {


    /**
     * validate program input argument
     *
     * @param args
     */
    private void validateInput(String[] args) {
        if(args.length<1){
            System.err.println("Please provide one argument as input file.");
            System.exit(1);
        }
        File file = new File(args[0]);
        if(!file.exists()){
            System.err.println("Input file "+args[0]+" doesn't exist.");
            System.exit(1);
        }
    }


    /**
     * start parse the input data file and calibrate the system
     *
     * @param file
     */
    private void calibrate(String file) {
        try {
            InputReader inputReader = new InputReader();
            List<Trainee> trainees = inputReader.createTrainees(new FileInputStream(file));
            for(Trainee trainee:trainees){
                trainee.calibrate();
                printOutput(trainee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run(String args[]){
        validateInput(args);
        calibrate(args[0]);
    }

    private static void printOutput(Trainee trainee){
        System.out.println(trainee.getPosition());
    }


    public static void main(String []args){
        Calibrator calibrator = new Calibrator();
        calibrator.run(args);
    }

}
