package org.example.service;

import org.example.enums.ParkingSlotStatus;
import org.example.model.ParkingLot;
import org.example.model.ParkingSpot;
import org.example.model.Vehicle;

import java.util.Optional;
import java.util.Set;

public class FindNearestParkingSlot implements SearchingAlgorithm{

    @Override
    public Optional<ParkingSpot> findParkingSpot(ParkingLot parkingLot, Vehicle vehicle) {
        Optional<ParkingSpot> parkingSpot = Optional.empty();
        Set<Integer> floorNums = parkingLot.getParkingFloors().keySet();
        for(Integer floor : floorNums) {
            parkingSpot = parkingLot.getParkingFloors().get(floor).getParkingSpots()
                    .stream().filter(spot -> spot.getClass().equals(vehicle.eligibleParkingSpot())
                    && spot.getStatus().equals(ParkingSlotStatus.AVAILABLE)).findFirst();

            if (parkingSpot.isPresent())
                return parkingSpot;
        }
        return parkingSpot;
    }
}
