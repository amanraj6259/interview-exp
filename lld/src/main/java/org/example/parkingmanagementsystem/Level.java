package org.example.parkingmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Level {

    int floorNo;

    List<ParkingSpot> parkingSpotList = new ArrayList<>();

    public Level(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }

    public void setParkingSpotList(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public ParkingSpot getAvailableParkingSpot(Vehicle vehicle)
    {
      for(ParkingSpot spot: parkingSpotList)
      {
          if(!spot.isOccupied && vehicle.vehicleType.name().equalsIgnoreCase(spot.spotType.name()))
          {
              return spot;
          }

      }
        return null;
    }

    public void addSpot(ParkingSpot spot)
    {
     parkingSpotList.add(spot);
    }

    public ParkingSpot parkVehicle(Vehicle vehicle)
    {
        ParkingSpot availableParkingSpot = getAvailableParkingSpot(vehicle);
        availableParkingSpot.assignVehicleToSpot(vehicle);
        return availableParkingSpot;

    }
}
