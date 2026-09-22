package com.lld;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactory.getVehicleObject("car");
        printVehicleDetails(vehicle);
    }

    private static void printVehicleDetails(Vehicle vehicle) {
        if(vehicle != null) {
            System.out.println("Vehicle Type: " + vehicle.getType());
            System.out.println("Number of Wheels: " + vehicle.getNumberOfWheels());
        }
    }
}