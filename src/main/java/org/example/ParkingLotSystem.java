package org.example;

import org.example.model.*;
import org.example.service.DisplayService;
import org.example.service.ParkingService;

import java.util.Optional;


public class ParkingLotSystem {

    private final DisplayService displayService;
    private final ParkingService parkingService;
    private ParkingLot parkingLot;

    ParkingLotSystem (DisplayService displayService, ParkingService parkingService) {
        this.displayService = displayService;
        this.parkingService = parkingService;
    }

    public ParkingLot createParkingLot(String id, int noOfFloors, int noOfSpots) {
        parkingLot = new ParkingLot(id);
        addParkingFloorsToParkingLot(noOfFloors, noOfSpots);
        return parkingLot;
    }

    public String parkVehicle(Vehicle vehicle) {
        Optional<ParkingTicket> parkingTicket = parkingService.parkVehicle(parkingLot, vehicle);
        return parkingTicket.isPresent()? parkingTicket.get().getId() : "Parking is full";
    }

    public String unParkVehicle(String ticketId) {
        Optional<ParkingTicket> parkingTicket = parkingService.unparkVehicle(parkingLot, ticketId);
        return parkingTicket.isPresent()? parkingTicket.get().getVehicle().getVehicleIdentificationNumber() : "Invalid Ticket";
    }

    public long displayFreeCount(Vehicle vehicle, int floorNum) {
        return displayService.getNumOfFreeSpotsForVehicleOnFloor(parkingLot, vehicle, floorNum);
    }

    public String displayFreeSlots(Vehicle vehicle) {
        return displayService.getAllFreeSpotsForVehicle(parkingLot, vehicle).toString();
    }

    private void addParkingFloorsToParkingLot(int noOfFloors, int noOfSpots) {
        for (int i=1; i<=noOfFloors; i++) {
            ParkingFloor parkingFloor = new ParkingFloor(i);
            addParkingSpotsToFloor(noOfSpots, parkingFloor);
            parkingLot.addParkingFloor(parkingFloor);
        }
    }

    private void addParkingSpotsToFloor(int noOfSpots, ParkingFloor parkingFloor) {

        if (noOfSpots > 0) {
            ParkingSpot parkingSpot = new LargeSpot(String.valueOf(1), parkingFloor);
            parkingFloor.addParkingSlot(parkingSpot);
            noOfSpots -= 1;
        }
        if (noOfSpots > 0) {
            for (int i=0; i<Math.min(2, noOfSpots); i++) {
                ParkingSpot parkingSpot = new MiniSpot(String.valueOf(i+2), parkingFloor);
                parkingFloor.addParkingSlot(parkingSpot);
            }
            noOfSpots -= 2;
        }
        if (noOfSpots > 0) {
            for (int i=0; i<noOfSpots; i++) {
                ParkingSpot parkingSpot = new CompactSpot(String.valueOf(i+4), parkingFloor);
                parkingFloor.addParkingSlot(parkingSpot);
            }
        }
    }



}
