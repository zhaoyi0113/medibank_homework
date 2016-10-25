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

    /**
     * create enum by the given shorthand string
     *
     * @param value the shorthand string for enum value
     * @return the enum value; null if got invalid parameter
     */
    public static Orientation getEnum(String value) {
        for (Orientation v : values()) {
            if (v.getValue().equalsIgnoreCase(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("Invalid enum value " + value);
    }

    public Orientation next() {
        return values()[(this.ordinal() + 1) % values().length];
    }

    public Orientation previous(){
        if(this.ordinal() == 0){
            return values()[values().length-1];
        }
        return values()[(this.ordinal() - 1) % values().length];
    }
}
