package com.medibank;

/**
 * Created by zhaoyi0113 on 25/10/2016.
 */
public class Movement {
    private String operation;

    public Movement(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
