package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.TicketStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ParkingTicket {

    private String id;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private TicketStatus status;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private double amount;
    public static int TICKET_NUM_AUTO_INCREMENT;

    public void setId(String parkingLotId) {
        StringBuilder sb = new StringBuilder();
        sb.append(parkingLotId).append("_").append(parkingSpot.getParkingFloor().getNumber())
                .append("_").append(parkingSpot.getId()).append("_").append(TICKET_NUM_AUTO_INCREMENT);
        TICKET_NUM_AUTO_INCREMENT++;
        this.id = sb.toString();
    }

}
