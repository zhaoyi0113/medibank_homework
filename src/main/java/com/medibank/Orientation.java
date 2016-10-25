package com.medibank;

/**
 * Created by zhaoyi0113 on 25/10/2016.
 */
public enum Orientation {
    EAST("E"), SOUTH("S"), WEST("W"), NORTH("N");

    String value;

    Orientation(String n) {
        value = n;
    }

    public String getValue() {
        return value;
    }

    public static Orientation getEnum(String value) {
        for(Orientation v : values()){
            if(v.getValue().equalsIgnoreCase(value)){
                return v;
            }
        }
        throw new IllegalArgumentException("Invalid enum value "+value);
    }
}
