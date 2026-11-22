package org.example.parkingmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
     List<Level> levels = new ArrayList<>();

     public void addLevels(Level level)
     {
         levels.add(level);
     }

     public void removeLevel(Level level)
     {
         levels.remove(level);
     }

     public void freeSpot(ParkingSpot spot)
     {
         spot.isOccupied =false;
         spot.vehicle =null;
     }

     public ParkingSpot findParkingSpot(Vehicle vehicle)
     {
         ParkingSpot availableParkingSpot  = null;
         for(Level l : levels)
         {
           availableParkingSpot = l.getAvailableParkingSpot(vehicle);
           if(availableParkingSpot!=null) {
               break;
           }
         }
         if(availableParkingSpot==null)
         {
             throw new RuntimeException("Parking is full");
         }
         return availableParkingSpot;
     }

     public void unParkVehicle(Ticket ticket)
     {
         ParkingSpot spot = ticket.spot;
         spot.removeVehicle(ticket.vehicle);
     }

     public synchronized  Ticket parkVehicle(Vehicle vehicle)
     {
         ParkingSpot availableParkingSpot  = findParkingSpot(vehicle);
         availableParkingSpot.assignVehicleToSpot(vehicle);
         return new Ticket(vehicle,availableParkingSpot);
     }
}
