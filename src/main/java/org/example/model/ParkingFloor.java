package org.example.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ParkingFloor {

    private int number;
    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(int number) {
        this.number = number;
        parkingSpots = new ArrayList<>();
    }

    public void addParkingSlot(ParkingSpot parkingSpot) {
        this.parkingSpots.add(parkingSpot);
    }

    public void removeParkingSlot(ParkingSpot parkingSpot) {
        this.parkingSpots.remove(parkingSpot);
    }
}
