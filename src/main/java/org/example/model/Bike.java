package org.example.model;

public class Bike extends Vehicle{

    public Bike(String vehicleIdentificationNumber) {
        super(vehicleIdentificationNumber);
    }

    @Override
    public Class<? extends ParkingSpot> eligibleParkingSpot() {
        return MiniSpot.class;
    }
}
