package org.example.parkingmanagementsystem;

public abstract class Vehicle {
    public String vehicleNo;

    VehicleType vehicleType;


    public Vehicle(String vehicleNo, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }
}
