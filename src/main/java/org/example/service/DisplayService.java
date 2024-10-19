package org.example.service;

import org.example.enums.ParkingSlotStatus;
import org.example.model.ParkingLot;
import org.example.model.Vehicle;

import java.util.Map;
import java.util.TreeMap;

public class DisplayService {

    public long getNumOfFreeSpotsForVehicleOnFloor(ParkingLot parkingLot, Vehicle vehicle, int floorNum) {
        return parkingLot.getParkingFloors().get(floorNum)
                .getParkingSpots().stream().filter(spot -> spot.getClass().equals(vehicle.eligibleParkingSpot())
                && spot.getStatus().equals(ParkingSlotStatus.AVAILABLE))
                .count();
    }

    public long getNumOfOccupiedSpotsForVehicleOnFloor(ParkingLot parkingLot, Vehicle vehicle, int floorNum) {
        return parkingLot.getParkingFloors().get(floorNum)
                .getParkingSpots().stream().filter(spot -> spot.getClass().equals(vehicle.eligibleParkingSpot())
                        && spot.getStatus().equals(ParkingSlotStatus.OCCUPIED))
                .count();
    }

    public Map<Long, Long> getAllFreeSpotsForVehicle(ParkingLot parkingLot, Vehicle vehicle) {
        Map<Long, Long> spotMap = new TreeMap<>();
        parkingLot.getParkingFloors().entrySet().forEach((entry -> {
            long count = entry.getValue().getParkingSpots().stream().filter(spot -> spot.getClass().equals(vehicle.eligibleParkingSpot())
                            && spot.getStatus().equals(ParkingSlotStatus.AVAILABLE))
                    .count();
            spotMap.put(entry.getKey().longValue(), count);
        }));
        return spotMap;
    }
}
