package org.example.parkingmanagementsystem;

import java.time.LocalDateTime;
import java.util.Date;

public class Ticket {

    int ticketId;

    Vehicle vehicle;

    ParkingSpot spot;

    LocalDateTime entryTime;

   static int counter = 0;


    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.ticketId = ++counter;
        this.vehicle = vehicle;
        this.spot = spot;
        this.entryTime = LocalDateTime.now();
    }
}
