package org.example.model;

import lombok.Getter;

import java.util.*;

@Getter
public class ParkingLot {

    private final String id;
    private final Map<Integer, ParkingFloor> parkingFloors;
    private final List<ParkingTicket> parkingTickets;

    public ParkingLot(String id) {
        this.id = id;
        this.parkingFloors = new TreeMap<>();
        this.parkingTickets = new ArrayList<>();
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloors.put(parkingFloor.getNumber(), parkingFloor);
    }

    public void removeParkingFloor(Integer floorNumber) {
        this.parkingFloors.remove(floorNumber);
    }

    public void addParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTickets.add(parkingTicket);
    }

    public Optional<ParkingTicket> getParkingTicket(String ticketId) {
        return this.parkingTickets.stream().filter(ticket -> ticket.getId().equals(ticketId)).findFirst();
    }
}
