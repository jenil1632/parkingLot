package org.example.model;

import org.example.enums.ParkingSlotStatus;

public class CompactSpot extends ParkingSpot {

    public CompactSpot(String id, ParkingFloor parkingFloor) {
        super(id, ParkingSlotStatus.AVAILABLE, parkingFloor);
    }
}
