package org.example.model;

import org.example.enums.ParkingSlotStatus;

public class MiniSpot extends ParkingSpot {

    public MiniSpot(String id, ParkingFloor parkingFloor) {
        super(id, ParkingSlotStatus.AVAILABLE, parkingFloor);
    }
}
