package org.example.service;

import org.example.model.ParkingLot;
import org.example.model.ParkingSpot;
import org.example.model.Vehicle;

import java.util.Optional;

public interface SearchingAlgorithm {

    Optional<ParkingSpot> findParkingSpot(ParkingLot parkingLot, Vehicle vehicle);
}
