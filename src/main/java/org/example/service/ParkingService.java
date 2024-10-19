package org.example.service;

import lombok.AllArgsConstructor;
import org.example.enums.ParkingSlotStatus;
import org.example.model.ParkingLot;
import org.example.model.ParkingSpot;
import org.example.model.ParkingTicket;
import org.example.model.Vehicle;

import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
public class ParkingService {

    private SearchingAlgorithm searchingAlgorithm;
    private TicketingService ticketingService;

    public Optional<ParkingTicket> parkVehicle(ParkingLot parkingLot, Vehicle vehicle) {

        Optional<ParkingTicket> parkingTicket = Optional.empty();

        Optional<ParkingSpot> parkingSpot = searchingAlgorithm.findParkingSpot(parkingLot, vehicle);
        if (parkingSpot.isEmpty())
            return parkingTicket;

        ParkingTicket ticket = ticketingService.issueTicket(vehicle, parkingLot.getId(), parkingSpot.get());

        parkingSpot.get().setParkingSlotStatus(ParkingSlotStatus.OCCUPIED);
        parkingLot.addParkingTicket(ticket);

        return Optional.of(ticket);
    }

    public Optional<ParkingTicket> unparkVehicle(ParkingLot parkingLot, String ticketId) {
        Optional<ParkingTicket> parkingTicket = parkingLot.getParkingTicket(ticketId);
        if (parkingTicket.isEmpty())
            return parkingTicket;

        parkingTicket.get().setExitTime(LocalDateTime.now());
        ticketingService.updateBill(parkingTicket.get());
        ticketingService.payBill(parkingTicket.get());

        ParkingSpot parkingSpot = parkingTicket.get().getParkingSpot();
        parkingSpot.setParkingSlotStatus(ParkingSlotStatus.AVAILABLE);

        return parkingTicket;
    }


}
