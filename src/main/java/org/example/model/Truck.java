package org.example.model;

public class Truck extends Vehicle{

    public Truck(String vehicleIdentificationNumber) {
        super(vehicleIdentificationNumber);
    }

    @Override
    public Class<? extends ParkingSpot> eligibleParkingSpot() {
        return LargeSpot.class;
    }
}
