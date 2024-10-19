package org.example;

import org.example.model.Bike;
import org.example.model.Car;
import org.example.model.Truck;
import org.example.service.*;

public class Main {
    public static void main(String[] args) {

        SearchingAlgorithm searchingAlgorithm = new FindNearestParkingSlot();
        TicketingService ticketingService = new TicketingService();
        ParkingService parkingService = new ParkingService(searchingAlgorithm, ticketingService);
        DisplayService displayService = new DisplayService();

        ParkingLotSystem parkingLotSystem = new ParkingLotSystem(displayService, parkingService);
        parkingLotSystem.createParkingLot("P1234", 2, 5);
        System.out.println(parkingLotSystem.displayFreeSlots(new Truck("xz")));
        System.out.println(parkingLotSystem.displayFreeSlots(new Car("xz")));
        System.out.println(parkingLotSystem.displayFreeSlots(new Bike("xz")));
        System.out.println(parkingLotSystem.parkVehicle(new Car("59Z")));
        System.out.println(parkingLotSystem.displayFreeSlots(new Car("xz")));

    }
}