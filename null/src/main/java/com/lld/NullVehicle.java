package com.lld;

/**
 * NullVehicle
 */
public class NullVehicle implements Vehicle {

    @Override
    public String getType() {
        return "No Vehicle Found";
    }

    @Override
    public String getNumberOfWheels() {
        return "0";
    }
    
}
