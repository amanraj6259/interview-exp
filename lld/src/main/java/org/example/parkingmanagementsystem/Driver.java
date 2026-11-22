package org.example.parkingmanagementsystem;

import java.util.Map;

public class Driver {

    public static  void main(String[] args)
    {
        Level level = new Level(1);
        ParkingLot parkingLot = new ParkingLot();
        level.addSpot(new ParkingSpot(101,SpotType.BIKE));
        level.addSpot(new ParkingSpot(102,SpotType.TRUCK));
        parkingLot.addLevels(level);

        Vehicle bike = new Bike("JH02AB7871",VehicleType.BIKE);
        Vehicle truck = new Truck("JH02AB7838",VehicleType.TRUCK);

        Vehicle car = new Car("JH02AB4878",VehicleType.CAR);

        EntryGate gate1 = new EntryGate(1,parkingLot);
        EntryGate gate2 = new EntryGate(2, parkingLot);
        //park vehicle
       System.out.println("---Parking Vehicle---");
       Ticket t1 =  gate1.entry(bike);
       System.out.println("Vehicle no "+ t1.vehicle +"is parked");
        System.out.println("---Parking Vehicle---");
        Ticket t2 =  gate2.entry(bike);
        System.out.println("Vehicle no "+ t1.vehicle +"is parked");

//        Ticket t2 = parkingLot.parkVehicle(truck);
//        System.out.println("Vehicle no "+ t2.vehicle +"is parked");
//        Ticket t3 = parkingLot.parkVehicle(car);
//        System.out.println("Vehicle no "+ t3.vehicle +"is parked");

    }
}
