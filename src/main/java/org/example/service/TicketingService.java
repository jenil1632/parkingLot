package org.example.service;

import org.example.enums.TicketStatus;
import org.example.model.ParkingSpot;
import org.example.model.ParkingTicket;
import org.example.model.Vehicle;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TicketingService {

    private ParkingRate parkingRate;

    public ParkingTicket issueTicket(Vehicle vehicle, String parkingLotId, ParkingSpot parkingSpot) {

        ParkingTicket ticket = new ParkingTicket();
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setParkingSpot(parkingSpot);
        ticket.setId(parkingLotId);
        ticket.setStatus(TicketStatus.OPEN);

        return ticket;
    }

    public void updateBill(ParkingTicket ticket) {
        long parkingTimeInHours = ChronoUnit.HOURS.between(ticket.getEntryTime(), ticket.getExitTime());

        double amount = parkingRate.calculateFee((int)parkingTimeInHours);
        ticket.setAmount(amount);
    }

    public void payBill(ParkingTicket ticket) {
        ticket.setStatus(TicketStatus.PAID);
    }
}
