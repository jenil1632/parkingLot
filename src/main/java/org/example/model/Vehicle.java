package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Vehicle {

    private String vehicleIdentificationNumber;

    public abstract Class<? extends ParkingSpot> eligibleParkingSpot();
}
