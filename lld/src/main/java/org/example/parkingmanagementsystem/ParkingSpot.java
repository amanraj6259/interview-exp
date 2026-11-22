package org.example.parkingmanagementsystem;

public class ParkingSpot {

    int spotId;

    SpotType spotType;

    boolean isOccupied;

    Vehicle vehicle;


    public ParkingSpot(int spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isOccupied = false;
        this.vehicle = null;
    }


    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public boolean canFitOnSpot(Vehicle vehicle)
    {
        if(spotType.name().equalsIgnoreCase(vehicle.vehicleType.name()) && !isOccupied)
        {
            return true;
        }
        return false;
    }

    public void assignVehicleToSpot(Vehicle vehicle)
    {
        isOccupied = true;
        this.vehicle = vehicle;
    }

    public void removeVehicle(Vehicle vehicle)
    {
        isOccupied= false;
        this.vehicle = vehicle;
    }
}
