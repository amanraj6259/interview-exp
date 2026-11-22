package org.example.parkingmanagementsystem;

public class Bike extends Vehicle{
    public Bike(String vehicleNo, VehicleType vehicleType) {
        super(vehicleNo, VehicleType.BIKE);
    }

    @Override
    public String toString() {
        return "Bike{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
