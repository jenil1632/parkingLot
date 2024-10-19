package org.example.model;

import org.example.enums.ParkingSlotStatus;

public class LargeSpot extends ParkingSpot {

    public LargeSpot(String id, ParkingFloor parkingFloor) {
        super(id, ParkingSlotStatus.AVAILABLE, parkingFloor);
    }
}
