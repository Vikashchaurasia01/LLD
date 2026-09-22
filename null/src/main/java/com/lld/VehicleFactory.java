package com.lld;

/**
 * VehicleFactory
 */
public class VehicleFactory {

    static Vehicle getVehicleObject(String typeOfvehicle) {
        if(typeOfvehicle.equalsIgnoreCase("Car")) {
            return new Car();
        }
        return new NullVehicle();
    }

}
