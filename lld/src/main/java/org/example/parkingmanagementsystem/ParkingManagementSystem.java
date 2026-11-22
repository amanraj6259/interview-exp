package org.example.parkingmanagementsystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
1. Problem statement (what the interviewer tells you)
You are required to design and implement a Parking Lot Management System for a commercial parking facility.

The parking lot has multiple floors, and each floor contains multiple parking spots. Vehicles arrive at the parking lot, receive a parking ticket, park in an appropriate spot, and eventually exit after paying the parking fee.

Your system should support different vehicle types and parking spot types.
Functional requirements
1. The parking lot should support multiple floors.
2. Each floor should contain multiple parking spots.
3. The system should support three vehicle types:
   - Motorcycle
   - Car
   - Truck
4. Parking spots should support different sizes:
   - Motorcycle spot
   - Compact spot
   - Large spot
5. A vehicle should be assigned a suitable available parking spot.
6. When a vehicle enters:
   - Generate a unique parking ticket.
   - Assign an available spot.
   - Record the entry timestamp.
7. When a vehicle exits:
   - Calculate the parking fee.
   - Accept payment.
   - Release the parking spot.
   - Mark the ticket as completed.
8. The system should show available and occupied spots on each floor.
9. If no suitable parking spot is available, reject the parking request gracefully.
10. A vehicle cannot occupy multiple spots simultaneously.

 */
