package com.lld;

public class Car implements Vehicle {

    @Override
    public String getType() {
        return "Car";
    }

    @Override
    public String getNumberOfWheels() {
        return "4";
    }
    
}
