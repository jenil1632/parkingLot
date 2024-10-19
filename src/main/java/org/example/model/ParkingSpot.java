package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.enums.ParkingSlotStatus;

@Getter
@AllArgsConstructor
public abstract class ParkingSpot {

    private String id;
    private ParkingSlotStatus status;
    private ParkingFloor parkingFloor;

    public void setParkingSlotStatus(ParkingSlotStatus status) {
        this.status = status;
    }

}
