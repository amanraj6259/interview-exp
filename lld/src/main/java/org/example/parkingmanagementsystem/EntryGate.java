package org.example.parkingmanagementsystem;

public class EntryGate {
    int gateId;
    ParkingLot parkingLot;


    public EntryGate(int gateId, ParkingLot parkingLot) {
        this.gateId = gateId;
        this.parkingLot = parkingLot;
    }
    Ticket entry(Vehicle vehicle)
    {
        System.out.println("Vehicle entering through gate " + gateId);
       return  parkingLot.parkVehicle(vehicle);
    }
}
