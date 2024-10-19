package org.example.model;

public class Car extends Vehicle{

    public Car(String vehicleIdentificationNumber) {
        super(vehicleIdentificationNumber);
    }

    @Override
    public Class<? extends ParkingSpot> eligibleParkingSpot() {
        return CompactSpot.class;
    }
}
